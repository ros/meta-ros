# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "dual quaternion operations"
AUTHOR = "achille <achille.verheye@gmail.com>"
ROS_AUTHOR = "achille <achille.verheye@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=58e54c03ca7f821dd3967e2a2cd1596e"

ROS_CN = "dual_quaternions"
ROS_BPN = "dual_quaternions"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    pyquaternion \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/Achllle/dual_quaternions-release/archive/release/noetic/dual_quaternions/0.3.2-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/dual_quaternions"
SRC_URI = "git://github.com/Achllle/dual_quaternions-release;${ROS_BRANCH};protocol=https"
SRCREV = "87f2dcc5486fa29a4259f69c90b9ca3da701aa58"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
