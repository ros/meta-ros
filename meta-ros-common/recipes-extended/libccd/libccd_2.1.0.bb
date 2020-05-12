DESCRIPTION = "libccd is library for a collision detection between two convex shapes."
HOMEPAGE = "https://github.com/danfis/libccd"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://BSD-LICENSE;md5=ff7a32175d897961df3eec70a6166429"

SRCREV = "7931e764a19ef6b21b443376c699bbc9c6d4fba8"
ROS_BRANCH ?= "branch=master"
SRC_URI = "git://github.com/danfis/libccd;${ROS_BRANCH};protocol=https"

S = "${WORKDIR}/git"

EXTRA_OECMAKE += "-DCMAKE_BUILD_TYPE=Release -DCCD_DOUBLE=1"

inherit pkgconfig cmake

FILES_${PN}-dev += "${libdir}/ccd/*.cmake"

# There is path to libm.so pointing to libccd RSS which we need to relocate
# recipe-sysroot/usr/lib/ccd/ccd-targets-release.cmake:  IMPORTED_LINK_INTERFACE_LIBRARIES_RELEASE "/jenkins/mjansa/build/ros/ros1-melodic-thud/tmp-glibc/work/core2-64-oe-linux/libccd/2.1.0-r0/recipe-sysroot/usr/lib/libm.so"
SSTATE_SCAN_FILES_append = " *.cmake"
