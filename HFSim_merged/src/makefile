HEADS = include.h structure.h function.h defs.h params.h
SRF2STOCH_OBJS = iofunc.o misc.o srf_subs.o
HFSIM_OBJS = iofunc.o misc.o srf_subs.o hb_high_v3.2.1.par1.o integ_diff.o wcc_getpeak.o wcc_rotate.o wcc_siteamp09.o fft1d.o
MERGE_OBJS = iofunc.o misc.o wcc_tfilter.o wcc_resamp_arbdt.o wcc_add.o fourg.o
HF_SYNTH_OBJS = srf2stoch.o ${HFSIM_OBJS} hfsim.o

GETPAR_DIR = ../../Getpar/getpar

LIBS = -lm ${GETPAR_DIR}/lib/libget.a
IFLAGS = -I${GETPAR_DIR}/include
LDLIBS = ${LIBS}

#LF_FLAGS = -D_FILE_OFFSET_BITS=32
#
# use following for large file capability
LF_FLAGS = -D_LARGEFILE_SOURCE -D_LARGEFILE64_SOURCE -D_FILE_OFFSET_BITS=64

UFLAGS = -O3

#FC = g77
#CC = gcc
#FC = tau_f90.sh
#CC = tau_cc.sh
CC = icc
FC = ifort

CFLAGS = ${UFLAGS} ${LF_FLAGS} ${IFLAGS}
#FFLAGS = ${UFLAGS} -ffixed-line-length-132 -finit-local-zero -Wuninitialized
FFLAGS = ${UFLAGS} -extend-source -nofor-main -zero

##### make options

all: hf_synth

hf_synth : hf_synth.o ${HF_SYNTH_OBJS}
	${FC} ${FFLAGS} -o hf_synth hf_synth.o ${HF_SYNTH_OBJS} ${LDLIBS}


clean :
	rm -f ${OBJS} ${GENRAND_OBJS} ${BAILEY_OBJS} ${GEOPROJ_OBJS} *.o
