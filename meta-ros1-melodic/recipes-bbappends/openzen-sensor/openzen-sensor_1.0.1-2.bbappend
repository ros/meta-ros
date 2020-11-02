# Copyright (c) 2020 LG Electronics, Inc.

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-don-t-reset-CMAKE_CXX_FLAGS.patch"

# The cmake subdirectory isn't under datadir/ROS_BPN.
FILES_${PN}-dev_prepend = " \
    ${ros_libdir}/cmake/OpenZen \
"
