#!/usr/bin/env python

import sys
import os

def build_src(site, fdloc, awp_comp):
	if awp_comp=='x':
		comp = "y"
	elif awp_comp=='y':
		comp = "x"
	elif awp_comp=='z':
		comp = "z"
	else:
		print "Error:  component %s not recognized, aborting." % comp
		sys.exit(1)
	
	fp_in = open(fdloc, "r")
	data = fp_in.readline()
	fp_in.close()
	
	[src_x, src_y] = data.split()
	
	fp_in = open("%s/data/f%s_src" % (sys.path[0], awp_comp))
	src_data = fp_in.readlines()
	fp_in.close()
	
	fp_out = open("comp_%s/input/%s_f%s_src" % (awp_comp, site, awp_comp), "w")
	#swap X and Y
	fp_out.write("%s %s 1\n" % (src_y, src_x))
	for line in src_data:
		fp_out.write(line)
	fp_out.flush()
	fp_out.close()
	return 0
