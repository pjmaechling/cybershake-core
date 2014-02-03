#!/usr/bin/env python

'''This wraps the GPU code, so we can take the IN3D file as input'''

import sys
import os
import shutil

full_path = os.path.abspath(sys.argv[0])
path_add = os.path.dirname(os.path.dirname(full_path))

sys.path.append(path_add)

import config

if len(sys.argv)<2:
	print "Usage: %s <IN3D file>" % sys.argv[0]
	sys.exit(1)

fp_in = open(sys.argv[1], "r")
in3d_data = fp_in.readlines()
fp_in.close()
params = dict()
for line in in3d_data:
	pieces = line.split()
	if len(pieces)>1:
		key = pieces[1]
		value = pieces[0]
		if value.find("'")!=-1:
			value = value.split("'")[1]
		params[key] = value
		
module_cmd = "/opt/modules/3.2.6.7/bin/modulecmd bash swap PrgEnv-cray PrgEnv-gnu; /opt/modules/3.2.6.7/bin/modulecmd bash load cudatoolkit"
mpi_cmd = config.getProperty("MPI_CMD")
nproc = int(params["NPX"])*int(params["NPY"])*int(params["NPZ"])
path = "%s/AWP-GPU-SGT/bin/pmcl3d" % config.getProperty("CS_PATH")


exec_string = "%s -n %d -N 1 %s -T %s --IGREEN %s --DH %s --DT %s --NSRC %s --NST %s -X %s -Y %s -Z %s -x %s -y %s --IFAULT %s --MEDIASTART %s --FL %s --FH %s --FP %s --READ_STEP %s --WRITE_STEP %s -o %s --INSGT %s -c %s --INSRC %s --INVEL %s --NTISKP_SGT %s --NTISKP %s" % (mpi_cmd, nproc, path, params["TMAX"], params["igreen"], params["DH"], params["DT"], params["NSRC"], params["NST"], params["NX"], params["NY"], params["NZ"], params["NPX"], params["NPY"], params["IFAULT"], params["MEDIARESTART"], params["FL"], params["FH"], params["FP"], params["READ_STEP"], params["WRITE_STEP"], params["SGTGRO"].rsplit("/", 1)[0], params["INSGT"], params["CHKP"], params["INSRC"], params["INVEL"], params["NTISKP_SGT"], params["NTISKP"])

#run exec_string
print exec_string
#exitcode = os.system("%s; %s" % (module_cmd, exec_string))
#sys.exit(0)
exitcode = os.system("%s" % exec_string)
if exitcode!=0:
	print "Job FAILED with exitcode %d." % ((exitcode >> 8) & 0xFF)
	sys.exit((exitcode >> 8) & 0xFF)

#move output file
print "Moving %s/SGT0020000 to %s" % (params["SGTGRO"].rsplit("/", 1)[0], params["SGTGRO"])
shutil.move("%s/SGT0020000" % params["SGTGRO"].rsplit("/", 1)[0], params["SGTGRO"])
sys.exit(0)