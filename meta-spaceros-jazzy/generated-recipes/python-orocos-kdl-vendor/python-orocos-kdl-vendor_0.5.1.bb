# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "\
    Wrapper around PyKDL, providing nothing but a dependency on PyKDL on some systems.\
    On others, it fetches and builds python_orocos_kdl locally.\
"
AUTHOR = "Jacob Perron <jacob@openrobotics.org>"
HOMEPAGE = "https://github.com/orocos/orocos_kinematics_dynamics"
LICENSE = "Apache-2.0 & LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=f12ef8c0445c08084ae92cf2dcb7ee92"

ROS_CN = "orocos_kdl_vendor"
ROS_BPN = "python_orocos_kdl_vendor"

ROS_BUILD_DEPENDS = "\
    orocos-kdl-vendor\
    pybind11-vendor\
    python3-pykdl\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
    ament-cmake-python-native\
    python-cmake-module-native\
"

ROS_EXPORT_DEPENDS = "\
    orocos-kdl-vendor\
    pybind11-vendor\
    python3-pykdl\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    orocos-kdl-vendor\
    pybind11-vendor\
    python3-pykdl\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-lint-auto\
    ament-lint-common\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=jazzy"
SRC_URI = "git://github.com/ros2/orocos_kdl_vendor.git;${ROS_BRANCH};protocol=https"
SRCREV = "f2457baafbdb6873b2c023e31781474417acb9de"
S = "${WORKDIR}/git/python_orocos_kdl_vendor"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
