# Copyright (c) 2020 LG Electronics, Inc.

EXTRA_OECMAKE += "-Dswri_nodelet_SHARE=${RECIPE_SYSROOT}${ros_datadir}/swri_nodelet"

# Fails with webOS OSE which by default uses gold
# swri-image-util/2.11.0-1-r0/recipe-sysroot/usr/opt/ros/melodic/lib/libswri_opencv_util.so: error: undefined reference to 'boost::random::random_device::~random_device()'
# the underlinkage should be fixed in meta-ros1-melodic/generated-recipes/marti-common/swri-opencv-util_2.11.0-1.bb
# but for now just use bfd
CXXFLAGS += "-fuse-ld=bfd"
