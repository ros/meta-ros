# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "The bcap service test package includes a node for testing bcap service node."
AUTHOR = "DENSO WAVE INCORPORATED <fa-support@denso-wave.com>"
ROS_AUTHOR = "DENSO WAVE INCORPORATED <fa-support@denso-wave.com>"
HOMEPAGE = "http://ros.org/wiki/bcap_service_test"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=58e54c03ca7f821dd3967e2a2cd1596e"

ROS_CN = "denso_robot_ros"
ROS_BPN = "bcap_service_test"

ROS_BUILD_DEPENDS = " \
    bcap-service \
    roscpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    roscpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    roscpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/DENSORobot/denso_robot_ros-release/archive/release/melodic/bcap_service_test/3.1.2-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/bcap_service_test"
SRC_URI = "git://github.com/DENSORobot/denso_robot_ros-release;${ROS_BRANCH};protocol=https"
SRCREV = "b132e4987de89c415afc476c5052f69762faac14"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
