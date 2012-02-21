
#ifndef RUPGEN_MISC_H
#define RUPGEN_MISC_H

void *check_malloc(size_t len);
void *check_realloc(void *ptr,size_t len);
//double frand(void);
double _sfrand(long *seed);
double _gaus_rand(float *sigma,float *mean,long *seed);
void _zapit(float *s, int n);

void set_ne(float *elon,float *elat,float *slon,float *slat,float *sn,float *se);
void set_ll(float *elon,float *elat,float *slon,float *slat,float *sn,float *se);
void swap_in_place(int n,char *cbuf);

#endif
