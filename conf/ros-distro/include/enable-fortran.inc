# Copyright (c) 2019 LG Electronics, Inc.

# FORTRAN support (copied from conf/local.conf.sample.extended)
# Enabling FORTRAN
# Note this is not officially supported and is just illustrated here to
# show an example of how it can be done
# You'll also need your fortran recipe to depend on libgfortran
FORTRAN_forcevariable = ",fortran"
RUNTIMETARGET_append_pn-gcc-runtime = " libquadmath"
