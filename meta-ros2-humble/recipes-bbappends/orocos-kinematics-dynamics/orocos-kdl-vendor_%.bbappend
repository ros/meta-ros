# Copyright (c) 2022 Acceleration Robotics S.L. <contact@accelerationrobotics.com>

# ERROR: orocos-kdl-3.3.1-1-r0 do_package_qa: QA Issue: non -dev/-dbg/nativesdk- package contains symlink .so: orocos-kdl path '/work/aarch64-oe-linux/orocos-kdl/3.3.1-1-r0/packages-split/orocos-kdl/usr/lib/liborocos-kdl.so' [dev-so]
inherit ros_insane_dev_so

# Missing license version in package.xml
# https://github.com/ros2-gbp/orocos_kinematics_dynamics-release/issues/2
LICENSE = "LGPL-2.1"

# # there is eigen3-cmake-module-native in ROS_BUILDTOOL_EXPORT_DEPENDS
# # but we need target dependency for orocos-kdl users like kdl-parser
# # to find it
# DEPENDS += "eigen3-cmake-module"

# ERROR: do_package: Files/directories were installed but not shipped in any package
#
# FILES:${PN} += " ${datadir}/orocos_kdl/cmake"
do_install:append() {
    rm -r ${D}${datadir}/orocos_kdl
    rm -r ${D}${libdir}/*${SOLIBSDEV}
    rm -r ${D}${libdir}/pkgconfig
}
