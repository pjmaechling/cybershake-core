#ifndef SRF_DEFS_H
#define SRF_DEFS_H

#define         NTMAX              100000
#define         SOMERVILLE_FLAG    1
#define         MAI_FLAG           2
#define         MINSLIP            1.0e-02

#define   DHYPO_FRAC       0.75     /* hypo at 0.75 down-dip width */
#define   SHYPO_STEP       20.0     /* hypo spacing at 20 km along strike */
#define   SHYPO_MIN_OFF    1.0      /* hypos start at 1.0 km along strike */
#define   SLIPS_TO_HYPOS   2    /* no. slip models = 2 times no. of hypos */

#define DEFAULT_VR_TO_VS_FRAC    0.8   /* vrup = 0.8 times local Vs */
#define DEFAULT_TSFAC            -0.5  /* tinit is shifted -0.5 at max_slip */

#define RDONLY_FLAGS    O_RDONLY
#define RDWR_FLAGS      O_RDWR
#define CROPTR_FLAGS    O_CREAT | O_TRUNC | O_RDWR

#define	MAXLINE	8192

#endif
