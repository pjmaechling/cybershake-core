#ifndef RUPGEN_FUNC_H
#define RUPGEN_FUNC_H

#include "structure.h"

void *_check_malloc(size_t);
void *_check_realloc(void *,size_t);
FILE *_fopfile(char*, char*);
int _opfile_ro(char *);
int _opfile(char *);
int _croptrfile(char *);
int _reed(int, void *, int);
int _rite(int, void *, int);

void fft2d(struct complex *, int, int, int,float *,float *);
void fft2d_fftw(struct complex *,int,int,int,float *,float *);

void kfilt(struct complex *,int,int,float *,float *,float *,float *,long *,int);
void kfilt_lw(struct complex *,int,int,float *,float *,float *,float *,long *,int,float *,float *);
void kfilt_lw_gaus(struct complex *,int,int,float *,float *,float *,float *,long *,int,float *,float *);
void kfilt_lw_H0(struct complex *,int,int,float *,float *,float *,float *,long *,int,float *,float *);

void kfilt_gaus(struct complex *,int,int,float *,float *,float *,float *,long *,int);
void kfilt_rphs(struct complex *,int,int,float *,float *,float *,float *,long *,int);
void kfilt_beta2(struct complex *,int,int,float *,float *,float *,float *,float *,long *);

void kfilt_gaus2(struct complex *,int,int,float *,float *,float *,float *,long *,int,float *,float *);
void kfilt_gaus2_asp(struct complex *,int,int,float *,float *,float *,float *,long *,int,float *,float *);
void kfilter(struct complex *,int,int,float *,float *,int,float *,float *);

void init_slip(struct complex *,int,int,float *,float *);
void init_slip_IO(struct complex *,int,int,int,int,float *,float *,int,char *);

void taper_slip(struct complex *,int,int,float *,float *);
void taper_slip_all(struct complex *,int,int,float *,float *,float *);
void taper_slip_all_r(float *,int,int,float *,float *,float *);

void scale_slip(struct pointsource *,struct complex *,int,int,int,float *,float *,float *,float *,float *,struct velmodel *,float *,float *);
void scale_slip_r(struct pointsource *ps,float *sr,int nx,int ny,int nys,float *dx,float *dy,float *dtop,float *dip,float *mom,struct velmodel *vm,float *savg,float *smax);

void write_field(char *,struct pointsource *,char *,int,int,float *,float *);
void write_spec(char *,float *,struct complex *,int,int,float *,float *,float *,float *,float *,float *,int);
void write_avgspec(char *,float *,int,int,int,float *,float *);

void default_velmodel(struct velmodel *);
void read_velmodel(char *,struct velmodel *);
void read_Fvelmodel(char *,struct velmodel *);
void conv2vrup(struct velmodel *,struct velmodel *,float *,float *,float *,float *,float *);
void conv2vrup_dd(struct velmodel *,struct velmodel *,float *,float *,float *,float *,float *,float *,float *);
void conv2vrup_dd2(struct velmodel *,struct velmodel *,float *,float *,float *,float *,float *,float *,float *,float *,float *);

void load_vsden(struct pointsource *ps,struct velmodel *vm,int nstk,int ndip);

double frand(void);
double _sfrand(long *);
double _gaus_rand(float *,float *,long *);

int _gen_brune_stf(float *,float *,float *,int,float *);
int gen_ucsb_stf(float *,float *,float *,int,float *);
int gen_Mliu_stf(float *,float *,float *,int,float *);
int gen_MliuP_stf(float *,float *,float *,float *,int,float *);
int gen_Oliu_stf(float *,float *,float *,int,float *);
int gen_OliuP_stf(float *,float *,float *,float *,int,float *);
int gen_tri_stf(float *,float *,float *,int,float *);
int _gen_2tri_stf(float *,float *,float *,int,float *,float *);

void _set_ll(float *,float *,float *,float *,float *,float *);
void _swap_in_place(int,char *);

struct pointsource *_read_ruppars(char *,struct pointsource *,float *,int *,int *,float *,float *,float *,float *,float *,float *,float *);
struct pointsource *read_gsfpars(char *,struct pointsource *,struct generic_slip *,float *,float *,float *,float *);
struct pointsource *read_gsfpars_vsden(char *,struct pointsource *,struct generic_slip *,float *,float *,float *,float *,int);
struct pointsource *set_ruppars(struct pointsource *,float *,int *,int *,float *,float *,float *,float *,float *,float *,float *,float *);

void _init_plane_srf(struct standrupformat *,struct generic_slip *,float *,float *,int,int,float *,float *,float *,float *,float *,float *,float *,float *,float *);
void _load_slip_srf(struct standrupformat *,struct stfpar *,struct pointsource *);
void _load_slip_srf_dd2(struct standrupformat *,struct stfpar2 *,struct pointsource *,long *,struct velmodel *);
void _load_slip_srf_dd3(struct standrupformat *,struct stfpar2 *,struct pointsource *,float *,struct velmodel *);
void _load_slip_srf_dd4(struct standrupformat *,struct stfpar2 *,struct pointsource *,float *,float *,struct velmodel *);
void _load_slip_srf_dd4_vsden(struct standrupformat *,struct stfpar2 *,struct pointsource *,float *,float *);
void load_vsden_srf(struct standrupformat *srf,struct velmodel *vmod);
void _load_rupt_srf(struct standrupformat *,struct pointsource *,float *,float *);
void _write_srf(struct standrupformat *,char *,int);
void write2gsf(struct generic_slip *,struct pointsource *,char *,char *);
void write2srf(struct standrupformat *,char *,int);

void free_srf_stf(struct standrupformat *);

void gseed(long *seed,struct pointsource *psrc,float *flen,float *fwid,float *dtop,float *mag);
void rhypo_uniform(long *seed,float *shyp,float *dhyp,float *flen,float *fwid);
float rhypo1_lintaper(long *seed,struct hypo_distr_params *hpar);

void get_rspeed(struct velmodel *,float *,struct pointsource *,int,int,float *,float *,float *,float *,float *,float *,float *,float *,float *,float *,float *,int);
void get_rspeed_vsden(float *,struct pointsource *,int,int,float *,float *,float *,float *,float *,float *,float *,float *,float *,float *,float *,int);
void get_rspeed_rvfslip(struct velmodel *,float *,struct pointsource *,float *,int,int,float *,float *,float *,float *,float *,float *,float *,float *,float *,float *);
void get_rslow(float *rspd,double *rslw,int nx,int ny,float *,long *seed);
void get_rslow_stretch(float *rspd,int ns,int nd,double *rslw,int nsfd,int ndfd,int isoff,int idoff,float *tsf,long *seed);

void gcproj(float *,float *,float *,float *,float *,double *,double *,double *,double *,int);
void gen_matrices(double *,double *,float *,float *,float *);

void latlon2km(float *,float *,float *,float *,float *);
void set_g2(float *,float *);
void geocen(float *,double);
void _zapit(float *, int);

int get_seg_bounds(struct standrupformat *,float *);
void get_rsegdelay(float *,int,int,double *,int,float *,float *,float *);

extern void wfront2d_(int *, int *, int *, int *, double *, int *, double *, double *, int *, double *, int *);
extern void fourg_(struct complex *, int *, int *, float *);

void copy_psrc(struct pointsource *,struct pointsource *,int,int);

void shift_phase(struct complex *,int,int,float *,float *,double *,double *);
void get_rupt(struct velmodel* vm, float* h, float* srcd, float* recd, float* srcr, float* recr, double* p, double* rad, float* tt);
void _zapit(float* s,int n);

void _write_srf1(struct standrupformat *srf,char *file,int bflag);
void _write_srf2(struct standrupformat *srf,char *file,int bflag);

void load_command_srf(struct standrupformat *srf,int ac,char **av);
void load_seed_srf(struct standrupformat *srf,int starting_seed,int ending_seed);

#ifdef _USE_MEMCACHED
int mc_genslip(int ac,char **av, rg_stats_t *stats, struct standrupformat* srf, int state, char* mc_server);
struct pointsource* _mc_read_ruppars(char *file,struct pointsource *psrc,float *mag,int *nx,int *ny,float *dx,float *dy,float *dtop,float *stk,float *dip,float *elon,float *elat, char* mc_server);
#else
int genslip(int ac,char **av, rg_stats_t *stats, struct standrupformat* srf, int state);
#endif

#endif

