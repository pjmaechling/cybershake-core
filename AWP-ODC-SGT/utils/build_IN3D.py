#!/usr/bin/env python

'''This script constructs an IN3D file for a CyberShake AWP-ODC-SGT run.
Some values are taken from data/IN3D.ref;  the others are determined based on the run.
X and Y are swapped from the RWG system, which is what all the input files are based on.'''

import sys
import os
import math

#will keep # of cores below this
CORE_COUNT = 4000

def build_IN3D(site, gridout, awp_comp, frequency):
	fp_in = open("%s/data/IN3D.ref" % (sys.path[0]), "r")
	data = fp_in.readlines()
	fp_in.close()

	param = dict()
	
	for line in data:
		pieces = line.split("=")
		param[pieces[0]] = pieces[1].strip()

	#determine igreen
	igreen = 0
	if awp_comp=='x':
		#swap x and y
		comp = 'y'
		igreen = 4
	elif awp_comp=='y':
		#swap x and y
		comp = 'x'
		igreen = 5
	elif awp_comp=='z':
		comp = 'z'
		igreen = 6
	else:
		print "Component %s not recognized, aborting." % comp
		sys.exit(2)
	
	param["igreen"] = igreen

	#determine DH, DT, NST, READ_STEP, WRITE_STEP, FP
	param["DH"] = round(100.0/frequency, 1)
	param["DT"] = 0.005/frequency
	param["NST"] = int(round(40000.0/frequency, 0))
	param["FP"] = frequency
	param["READ_STEP"] = param["NST"]
	param["WRITE_STEP"] = param["READ_STEP"]/10
	param["WRITE_STEP2"] = param["WRITE_STEP"]
	
	#determine NX, NY, NZ
	fp_in = open(gridout, "r")
	data = fp_in.readlines()
	fp_in.close()
	#remember, X and Y are flipped
	ny = int((data[1].split("="))[1])
	nx = int((data[1+ny+2].split("="))[1])
	nz = int((data[1+ny+2+nx+2].split("="))[1])
	
	param["NX"] = nx
	param["NY"] = ny
	param["NZ"] = nz
	
	#determine NPX, NPY, NPZ
	#hard-code npz to 4 for now
	npz = 4
	nxny_cores = CORE_COUNT/npz
	
	#Since we have 5 points per km and the dimensions are multiples of 10 km, we know 50 is a factor
	npx = nx/50
	npy = ny/50
	
	#Look for highest core count less than CORE_COUNT while 2*NX/NPX > NY/NPY, and NX/NPX < 2*NY/NPY

	#check and see if we are under the threshold
	adjust = 1
	if npx*npy>nxny_cores:
		#how far over?
		scale_factor = math.sqrt(float(nxny_cores)/float(npx*npy))
		#Adjust npx
		npx = int(npx*scale_factor)
		while not (nx % npx == 0) and npx>0 and npx<nx:
			npx += adjust
			adjust = int(math.copysign(abs(adjust)+1, -1*adjust))
		if npx<=0 or npx>=nx:
			print "Error:  npx is %d, aborting." % npx
		print "Chose %d for npx" % npx
		#Adjust npy
		npy = nxny_cores/npx
		#This is the largest it can be without exceeding CORE_COUNT; search down
		while not (ny % npy == 0) and npy>0 and npy<ny:
			npy -= 1
		if npy<=0 or npy>=ny:
			print "Error:  npy is %d, aborting." % npy
		if npx>10*npy or npy>10*npx:
			print "Error in determining load-balanced npx and npy.  Trying to fit %d cores with grid dimensions (%d, %d, %d), but the best we could do was np = (%d, %d, %d).  Aborting.  Perhaps try a different core limit?" % (CORE_COUNT, nx, ny, nz, npx, npy, npz)
			sys.exit(2)
	
	#Now, see if we can improve
        npx_best = npx
        npy_best = npy
	cores_used = npx_best*npy_best
	print npx, npy
	sys.stdout.flush()
	while (2*nx/npx > ny/npy) and (nx/npx < 2*ny/npy) and npx<nx and npy<ny and npx>0 and npy>0:
		#continue from where we left off
		npx += adjust
		adjust = int(math.copysign(abs(adjust)+1, -1*adjust))
		while not (nx % npx == 0) and npx<nx and npx>0 and npx<nx:
			print "npx: %d\n" % npx
			sys.stdout.flush()
                        npx += adjust
			adjust = int(math.copysign(abs(adjust)+1, -1*adjust))
		npy = nxny_cores/npx
		while not (ny % npy == 0) and npy>0 and npx<ny:
			#Search down
			print "npy: %d\n" % npy
			sys.stdout.flush()
			npy -= 1
		#if the values are too extreme, stop looking
		if not ((2*nx/npx > ny/npy) and (nx/npx < 2*ny/npy)):
			break
		if npx*npy > cores_used:
			npx_best = npx
			npy_best = npy
			cores_used = npx*npy

	print "Chose %d for npy" % npy_best
	
	param["NPX"] = npx_best
	param["NPY"] = npy_best
	param["NPZ"] = npz
	
	#doesn't really matter, but set N<BG|ED><comp> values
	param["NBGX"] = 1
	param["NEDX"] = nx
	param["NBGY"] = 1
	param["NEDY"] = ny
	param["NBGZ"] = 1
	param["NEDZ"] = nz
	param["NBGX2"] = 1
	param["NEDX2"] = nx
	param["NBGY2"] = 1
	param["NEDY2"] = ny
	param["NBGZ2"] = 1
	param["NEDZ2"] = nz
	
	#paths to INSRC, INVEL, INSGT, SGTGR0
	param["INSRC"] = "comp_%s/input/%s_f%s_src" % (awp_comp, site, awp_comp)
	param["INVEL"] = "comp_%s/input/awp.%s.media" % (awp_comp, site)
	param["INSGT"] = "comp_%s/input/awp.%s.cordfile" % (awp_comp, site)
	param["SGTGRO"] = "comp_%s/output_sgt/awp-strain-%s-f%s" % (awp_comp, site, awp_comp)

	
	#write IN3D file
	fp_out = open("IN3D.%s.%s" % (site, awp_comp), "w")
	fp_out.write("%9s igreen\n" % (param["igreen"]))
	fp_out.write("%9s TMAX\n\n" % (param["TMAX"]))
	fp_out.write("%9s DH\n" % (param["DH"]))
	fp_out.write("%9s DT\n\n" % (param["DT"]))
	fp_out.write("%9s NPC\n\n" % (param["NPC"]))
	fp_out.write("%9s ND\n" % (param["ND"]))
	fp_out.write("%9s ARBC\n" % (param["ARBC"]))
	fp_out.write("%9s PHT\n\n" % (param["PHT"]))
	fp_out.write("%9s NSRC\n" % (param["NSRC"]))
	fp_out.write("%9s NST\n\n" % (param["NST"]))
	fp_out.write("%9d NX\n" % (param["NX"]))
	fp_out.write("%9d NY\n" % (param["NY"]))
	fp_out.write("%9d NZ\n\n" % (param["NZ"]))
	fp_out.write("%9d NPX\n" % (param["NPX"]))
	fp_out.write("%9d NPY\n" % (param["NPY"]))
	fp_out.write("%9d NPZ\n\n" % (param["NPZ"]))
	fp_out.write("%9s IFAULT\n" % (param["IFAULT"]))
	fp_out.write("%9s CHECKPOINT\n" % (param["CHECKPOINT"]))
	fp_out.write("%9s ISFCVLM\n" % (param["ISFCVLM"]))
	fp_out.write("%9s IMD5\n" % (param["IMD5"]))
	fp_out.write("%9s IVELOCITY\n" % (param["IVELOCITY"]))
	fp_out.write("%9s MEDIARESTART\n" % (param["MEDIARESTART"]))
	fp_out.write("%9s NVAR\n" % (param["NVAR"]))
	fp_out.write("%9s IOST\n" % (param["IOST"]))
	fp_out.write("%9s PARTDEG\n" % (param["PARTDEG"]))
	fp_out.write("%9s IO_OPT\n" % (param["IO_OPT"]))
	fp_out.write("%9s PERF_MEAS\n" % (param["PERF_MEAS"]))
	fp_out.write("%9s IDYNA\n" % (param["IDYNA"]))
	fp_out.write("%9s SOCALQ\n\n" % (param["SOCALQ"]))
	fp_out.write("%9s NVE\n\n" % (param["NVE"]))
	fp_out.write("%9s MU_S\n" % (param["MU_S"]))
	fp_out.write("%9s MU_D\n\n" % (param["MU_D"]))
	fp_out.write("%9s FL\n" % (param["FL"]))
	fp_out.write("%9s FH\n" % (param["FH"]))
	fp_out.write("%9s FP\n\n" % (param["FP"]))
	fp_out.write("%9s READ_STEP\n" % (param["READ_STEP"]))
	fp_out.write("%9s WRITE_STEP\n" % (param["WRITE_STEP"]))
	fp_out.write("%9s WRITE_STEP2\n\n" % (param["WRITE_STEP2"]))
	fp_out.write("%9s NBGX\n" % (param["NBGX"]))
	fp_out.write("%9s NEDX\n" % (param["NEDX"]))
	fp_out.write("%9s NSKPX\n" % (param["NSKPX"]))
	fp_out.write("%9s NBGY\n" % (param["NBGY"]))
	fp_out.write("%9s NEDY\n" % (param["NEDY"]))
	fp_out.write("%9s NSKPY\n" % (param["NSKPY"]))
	fp_out.write("%9s NBGZ\n" % (param["NBGZ"]))
	fp_out.write("%9s NEDZ\n" % (param["NEDZ"]))
	fp_out.write("%9s NSKPZ\n\n" % (param["NSKPZ"]))
	fp_out.write("%9s NTISKP\n" % (param["NTISKP"]))
	fp_out.write("%9s NBGX2\n" % (param["NBGX2"]))
	fp_out.write("%9s NEDX2\n" % (param["NEDX2"]))
	fp_out.write("%9s NSKPX2\n" % (param["NSKPX2"]))
	fp_out.write("%9s NBGY2\n" % (param["NBGY2"]))
	fp_out.write("%9s NEDY2\n" % (param["NEDY2"]))
	fp_out.write("%9s NSKPY2\n" % (param["NSKPY2"]))
	fp_out.write("%9s NBGZ2\n" % (param["NBGZ2"]))
	fp_out.write("%9s NEDZ2\n" % (param["NEDZ2"]))
	fp_out.write("%9s NSKPZ2\n\n" % (param["NSKPZ2"]))
	fp_out.write("%9s NTISKP2\n\n" % (param["NTISKP2"]))
        fp_out.write("%9s NTISKP_SGT\n\n" % (param["NTISKP_SGT"]))
	fp_out.write("'comp_%s/%s' CHKP\n" % (awp_comp, param["CHKP"]))
	fp_out.write("'comp_%s/%s' CHKJ\n\n" % (awp_comp, param["CHKJ"]))
	fp_out.write("'%s' INSRC\n" % (param["INSRC"]))
	fp_out.write("'%s' INVEL\n\n" % (param["INVEL"]))
	fp_out.write("'%s' INSGT\n\n" % (param["INSGT"]))
	fp_out.write("'comp_%s/%s' SXRGO\n" % (awp_comp, param["SXRGO"]))
	fp_out.write("'comp_%s/%s' SYRGO\n" % (awp_comp, param["SYRGO"]))
	fp_out.write("'comp_%s/%s' SZRGO\n\n" % (awp_comp, param["SZRGO"]))
	fp_out.write("'comp_%s/%s' SXRGO2\n" % (awp_comp, param["SXRGO2"]))
	fp_out.write("'comp_%s/%s' SYRGO2\n" % (awp_comp, param["SYRGO2"]))
	fp_out.write("'comp_%s/%s' SZRGO2\n\n" % (awp_comp, param["SZRGO2"]))
	fp_out.write("'%s' SGTGRO\n\n" % (param["SGTGRO"]))
	fp_out.write("'comp_%s/%s' SGSN\n" % (awp_comp, param["SGSN"]))
	
	fp_out.flush()
	fp_out.close()

	return 0
