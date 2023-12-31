#include "include.h"
#include "defs.h"
#include "structure.h"

void init_sgtfileparams(struct sgtfileparams* sfp) {
	sfp->xfile[0] = '\0';
	sfp->yfile[0] = '\0';
	sfp->zfile[0] = '\0';

	sfp->xfp = NULL;
	sfp->yfp = NULL;
	sfp->zfp = NULL;

	sfp->head_off = 0;
	sfp->xcur_off = 0;
	sfp->ycur_off = 0;
	sfp->zcur_off = 0;

	sfp->x_head_fp = NULL;
	sfp->y_head_fp = NULL;
	sfp->z_head_fp = NULL;

	sfp->xfile_header[0] = '\0';
	sfp->yfile_header[0] = '\0';
	sfp->zfile_header[0] = '\0';

	sfp->x_head_off = 0;
	sfp->y_head_off = 0;
	sfp->z_head_off = 0;
}

void construct_sgtmast_datatype(MPI_Datatype* sgtmaster_type) {
	int lengths[9] = {1, 1, 1, 1, 1, 1, 1, 1, 1};
	int si = sizeof(int);
	int sf = sizeof(float);
	int sll = sizeof(long long);
	MPI_Aint offsets[9] = {0, si, si+sf, si+2*sf, si+3*sf, si+4*sf, si+5*sf, si+5*sf+si, si+5*sf+2*si};
	MPI_Datatype types[9] = {MPI_INT, MPI_FLOAT, MPI_FLOAT, MPI_FLOAT, MPI_FLOAT, MPI_FLOAT, MPI_INT, MPI_INT, MPI_INT};
	MPI_Type_struct(9, lengths, offsets, types, sgtmaster_type);
	MPI_Type_commit(sgtmaster_type);
}

void construct_sgtindx_datatype(MPI_Datatype* sgtindex_type) {
	int lengths_indx[5] = {1, 1, 1, 1, 1};
	int si = sizeof(int);
	int sll = sizeof(long long);
	MPI_Aint offsets_indx[5] = {0, sll, sll+si, sll+2*si, sll+3*si};
	MPI_Datatype types_indx[5] = {MPI_LONG, MPI_INT, MPI_INT, MPI_INT, MPI_FLOAT};
	MPI_Type_struct(5, lengths_indx, offsets_indx, types_indx, sgtindex_type);
	MPI_Type_commit(sgtindex_type);
}

void construct_sgtheader_datatype(MPI_Datatype* sgtheader_type) {
	//it's just easier
    MPI_Type_contiguous(128, MPI_BYTE, sgtheader_type);
    MPI_Type_commit(sgtheader_type);
}

void construct_sgtdata_datatype(MPI_Datatype* sgtdata_type, int nt) {
	//it's just easier
    MPI_Type_contiguous(N_SGTvars*nt, MPI_FLOAT, sgtdata_type);
    MPI_Type_commit(sgtdata_type);
}

void construct_worker_message_datatype(MPI_Datatype* worker_message_type) {
	/*
	 * typedef struct worker_message {
	int msg_type;
	worker_task task;
} worker_msg;
	 *
	 *worker_task:
	 * char rupture_filename[256];
	int source_id;
	int rupture_id;
	int num_slips;
	int num_hypos;
	int starting_rv_id;
	int ending_rv_id;
	int rup_var_spacing;
	 */
	MPI_Datatype worker_task_type;
	int lengths_indx[2] = {256, 7};
	MPI_Aint offsets_indx[2];
	offsets_indx[0] = 0;
	offsets_indx[1] = 256;
	MPI_Datatype types_indx[2] = {MPI_CHAR, MPI_INT};
	MPI_Type_struct(2, lengths_indx, offsets_indx, types_indx, &worker_task_type);
    MPI_Type_commit(&worker_task_type);

    lengths_indx[0] = 1;
    lengths_indx[1] = 1;
    offsets_indx[0] = 0;
    offsets_indx[1] = sizeof(int);
    types_indx[0] = MPI_INT;
    types_indx[1] = worker_task_type;
    MPI_Type_struct(2, lengths_indx, offsets_indx, types_indx, worker_message_type);
    MPI_Type_commit(worker_message_type);
}

void construct_rvinfo_datatype(MPI_Datatype* rvinfo_type) {
    /*
 * typedef struct rv_info {
        int source_id;
        int rupture_id;
        int rup_var_id;
        float rvfrac;
        int seed;
    } rv_info; */
    int lengths[5] = {1, 1, 1, 1, 1};
    int si = sizeof(int);
    int sf = sizeof(float);
    MPI_Aint offsets[5] = {0, si, 2*si, 3*si, 3*si+sf};
    MPI_Datatype types[5] = {MPI_INT, MPI_INT, MPI_INT, MPI_FLOAT, MPI_INT};
    MPI_Type_struct(5, lengths, offsets, types, rvinfo_type);
    MPI_Type_commit(rvinfo_type);
}

