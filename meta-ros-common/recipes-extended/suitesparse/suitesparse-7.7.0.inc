# Copyright (c) 2019 LG Electronics, Inc.
# Copyright (c) 2024 Wind River Systems, Inc.

SUMMARY = "SuiteSparse is a suite of sparse matrix algorithms"
DESCRIPTION = "SuiteSparse is a suite of sparse matrix algorithms, including: UMFPACK(multifrontal LU factorization), CHOLMOD(supernodal Cholesky, with CUDA acceleration), SPQR(multifrontal QR) and many other packages."

LIC_FILES_CHKSUM = "file://../LICENSE.txt;md5=f412ac88bc7d8314b59d3d103e0ffb75"

S = "${WORKDIR}/git"

SRC_URI = "git://github.com/DrTimothyAldenDavis/SuiteSparse.git;branch=stable;protocol=https"

SRCREV = "13806726cbf470914d012d132a85aea1aff9ee77"
