#ifndef RUPGEN_API_H
#define RUPGEN_API_H

int rupgen_init(char* rup_dir);
int rupgen_get_num_rv(int source, int rupture, rg_stats_t *stats);
int rupgen_genslip(int source, int rupture, int slip, int hypo, rg_stats_t *stats, struct standrupformat* srf);

#endif