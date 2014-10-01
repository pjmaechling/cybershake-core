HEADS = include.h structure.h function.h defs.h
OBJS = iofunc.o misc.o ruptime.o srf_subs.o

GETPAR = /work/00940/tera3d/CyberShake/software/Getpar/getpar

#GCCLIB = /usr/lib/gcc/x86_64-redhat-linux/3.4.6
FORTLIBS = -lfrtbegin -lg2c -lgcc_s
FC = ifort

#GCCLIB = /usr/lib/gcc/x86_64-redhat-linux/4.3.2
#FORTLIBS = -lgfortranbegin -lgfortran -lgcc_s
#FC = gfortran


LDLIBS = ${OBJS} -lget -L${GETPAR}/lib -lm

#LF_FLAGS = -D_FILE_OFFSET_BITS=32
#
# use following for large file capability
LF_FLAGS = -D_LARGEFILE_SOURCE -D_LARGEFILE64_SOURCE -D_FILE_OFFSET_BITS=64
CFLAGS = -I${GETPAR}/include -Wall -I${TACC_FFTW3_INC} \
        -D_LARGEFILE_SOURCE -D_LARGEFILE64_SOURCE \
        -D_FILE_OFFSET_BITS=64 -DUSE_IOBUF_MACROS -xhost
#CFLAGS = -I${GETPAR}/include -Wall -I${TACC_FFTW3_INC} \
#        -D_LARGEFILE_SOURCE -D_LARGEFILE64_SOURCE \
#        -D_FILE_OFFSET_BITS=64 -DUSE_IOBUF_MACROS

UFLAGS = -O3 -g

CC = icc

CFLAGS := $(CFLAGS) ${UFLAGS} ${LF_FLAGS}

# Uncomment for memcached support
MEMC = /work/00940/tera3d/CyberShake/utils/libmemcached
CFLAGS := $(CFLAGS) -I${MEMC}/include -D_USE_MEMCACHED
LIBS = ${LDLIBS} -L${MEMC}/lib -lmemcached

FFLAGS = ${UFLAGS} -ffixed-line-length-132
#FFLAGS = ${UFLAGS} -132

##### make options

#generf : generf.o ${OBJS}
#	${FC} -o generf generf.o ${LDLIBS}

#fd_ruptime : fd_ruptime.c ${OBJS}
#	${CC} ${CFLAGS} -o fd_ruptime fd_ruptime.c ${LDLIBS}

#genslip-v3.3 : genslip-v3.3.c ${OBJS}
#	${CC} -o genslip-v3.3 genslip-v3.3.c ${LDLIBS}

#genslip-v3.3.1 : genslip-v3.3.1.c ${OBJS}
#	${CC} ${CFLAGS} -o genslip-v3.3.1 genslip-v3.3.1.c ${LIBS}
#	cp genslip-v3.3.1 ../../bin/

#test_rhypo : test_rhypo.c ${OBJS}
#	${CC} -o test_rhypo test_rhypo.c ${LDLIBS}

all: genslip-v3.3.1.fourg.o genslip-v3.3.1.fftw.o

genslip-v3.3.1.o : genslip-v3.3.1.fourg.c ${OBJS} slip.fourg..o fourg.o
	${CC} ${CFLAGS} -c -o genslip-v3.3.1.fourg.o genslip-v3.3.1.fourg.c ${LIBS}
	
genslip-v3.3.1.fftw.o : genslip-v3.3.1.fftw.c ${OBJS} slip.fftw.o
	${CC} ${CFLAGS} -c -o genslip-v3.3.1.fftw.o genslip-v3.3.1.fftw.c -Wl,-rpath,${TACC_FFTW3_LIB} -L${TACC_FFTW3_LIB} -lfftw3f ${LIBS} 

${OBJS} : ${HEADS}

clean :
	-rm -f ${OBJS} *.o