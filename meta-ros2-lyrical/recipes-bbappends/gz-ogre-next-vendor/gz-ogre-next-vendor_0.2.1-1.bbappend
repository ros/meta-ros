# Copyright (c) 2020 LG Electronics, Inc.
# Copyright (c) 2024 Wind River Systems, Inc.

inherit pkgconfig

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://use-system-ogre-next.patch"

DEPENDS += "ogre-next"

# libxaw is empty, the library is installed in libxaw6 and libxaw7 packages
# and ogre should get runtime dependency automatically through shlibs
RDEPENDS:${PN}:remove = "libxaw"

# libatomic is just one of the packages provided by gcc-runtime recipe
# but gcc-runtime recipe doesn't have libatomic in PROVIDES, so we cannot map
# libatomic in rosdep to libatomic (without adding libatomic to PROVIDES in gcc-runtime
# bbappend). And we cannot leave gcc-runtime in ROS_EXEC_DEPENDS, because
# gcc-runtime recipe doesn't have PN in PACKAGES (and we would still depend
# on do_package shlibs handling to add runtime dependency on actual package
# with libatomic library)
ROS_EXEC_DEPENDS:remove = "gcc-runtime"
# there is no native support for gcc-runtime, so also no libatomic, add it only for target builds
ROS_EXEC_DEPENDS:append-class-target = " libatomic"
# and also remove it from build time depends when buiding native rc-utils
DEPENDS:remove:class-native = "gcc-runtime-native gcc-runtime"
