DESCRIPTION = "libccd is library for a collision detection between two convex shapes."
HOMEPAGE = "https://github.com/danfis/libccd"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://BSD-LICENSE;md5=ff7a32175d897961df3eec70a6166429"

SRCREV = "bd1b39ddd990c4c7f23251f2916de6be3781140e"
ROS_BRANCH ?= "branch=master"
SRC_URI = "git://github.com/danfis/libccd;${ROS_BRANCH};protocol=https"

S = "${WORKDIR}/git"

EXTRA_OECMAKE += "-DCMAKE_BUILD_TYPE=Release -DCCD_DOUBLE=1"

inherit pkgconfig cmake
