# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_galactic
inherit ros_superflore_generated

DESCRIPTION = "Examples for working with Lanelet2"
AUTHOR = "Fabian Poggenhans <fabian.poggenhans@kit.edu>"
ROS_AUTHOR = "Fabian Poggenhans <fabian.poggenhans@kit.edu>"
HOMEPAGE = "https://github.com/fzi-forschungszentrum-informatik/lanelet2.git"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "lanelet2"
ROS_BPN = "lanelet2_examples"

ROS_BUILD_DEPENDS = " \
    lanelet2-core \
    lanelet2-io \
    lanelet2-projection \
    lanelet2-python \
    lanelet2-routing \
    lanelet2-traffic-rules \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-core-native \
    mrt-cmake-modules-native \
"

ROS_EXPORT_DEPENDS = " \
    lanelet2-core \
    lanelet2-io \
    lanelet2-projection \
    lanelet2-python \
    lanelet2-routing \
    lanelet2-traffic-rules \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = " \
    mrt-cmake-modules-native \
"

ROS_EXEC_DEPENDS = " \
    lanelet2-core \
    lanelet2-io \
    lanelet2-projection \
    lanelet2-python \
    lanelet2-routing \
    lanelet2-traffic-rules \
    ros2cli \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    gtest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/fzi-forschungszentrum-informatik/lanelet2-release/archive/release/galactic/lanelet2_examples/1.1.1-2.tar.gz
ROS_BRANCH ?= "branch=release/galactic/lanelet2_examples"
SRC_URI = "git://github.com/fzi-forschungszentrum-informatik/lanelet2-release;${ROS_BRANCH};protocol=https"
SRCREV = "2e3361291cc6b1fcb323a2d36025ee22315d5065"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
