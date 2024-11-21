# Copyright (c) 2021 LG Electronics, Inc.

# enable cblas
EXTRA_OECMAKE += "-DCBLAS=ON"

# fix configure error during FortranCInterface detect
OECMAKE_FIND_ROOT_PATH_MODE_PROGRAM = "BOTH"

# We were using openblas recipe to build cblas
PROVIDES += "openblas"

# ERROR: lapack-3.12.0-r0 do_package_qa: QA Issue: File /usr/lib/liblapack.so.3.12.0 in package lapack contains reference to TMPDIR [buildpaths]
# ERROR: lapack-3.12.0-r0 do_package_qa: QA Issue: File /usr/lib/libblas.so.3.12.0 in package lapack contains reference to TMPDIR [buildpaths]
#
# The gfortran compiler does not have a flag to remove the source file from the output
# We must ignore the QA issues instead.
INSANE_SKIP:${PN} += "buildpaths"
