# Copyright (c) 2019 LG Electronics, Inc.

SUMMARY = "SuiteSparse is a suite of sparse matrix algorithms"
DESCRIPTION = "SuiteSparse is a suite of sparse matrix algorithms, including: UMFPACK(multifrontal LU factorization), CHOLMOD(supernodal Cholesky, with CUDA acceleration), SPQR(multifrontal QR) and many other packages."

LIC_FILES_CHKSUM = "file://../LICENSE.txt;md5=0257b62ceb5e6454ee85558f9333609a"

# Cannot use PV here, because e.g. metis in SuiteSparse 5.4.0 has version 5.1.0
SRC_URI = "http://faculty.cse.tamu.edu/davis/SuiteSparse/SuiteSparse-5.4.0.tar.gz"

SRC_URI[md5sum] = "4a6d4e74fc44c503f52996ae95cad03a"
SRC_URI[sha256sum] = "374dd136696c653e34ef3212dc8ab5b61d9a67a6791d5ec4841efb838e94dbd1"
