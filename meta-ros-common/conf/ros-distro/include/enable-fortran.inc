# Copyright (c) 2019-2020 LG Electronics, Inc.

# FORTRAN support (derived from openembedded-core/meta/conf/local.conf.sample.extended)
# Enabling FORTRAN
# Note this is not officially supported by OpenEmbedded.
FORTRAN:forcevariable = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'fortran', '', ',fortran', d)}"
RUNTIMETARGET:append:pn-gcc-runtime = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'fortran', '', ' libquadmath', d)}"
