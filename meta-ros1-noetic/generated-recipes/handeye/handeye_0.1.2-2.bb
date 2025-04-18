# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "The handeye package"
AUTHOR = "Francisco Suarez-Ruiz <fsuarez6@gmail.com>"
ROS_AUTHOR = "Francisco Suarez-Ruiz <fsuarez6@gmail.com>"
HOMEPAGE = "http://wiki.ros.org/handeye"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "BSD 3-Clause"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d84cded89c768806cb84461439476daa"

ROS_CN = "handeye"
ROS_BPN = "handeye"

ROS_BUILD_DEPENDS = " \
    geometry-msgs \
    message-generation \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    geometry-msgs \
    message-runtime \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    baldor \
    criutils \
    geometry-msgs \
    message-runtime \
    python3-matplotlib \
    python3-numpy \
    python3-scipy \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    rostest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/crigroup/handeye-release/archive/release/noetic/handeye/0.1.2-2.tar.gz
ROS_BRANCH ?= "branch=release/noetic/handeye"
SRC_URI = "git://github.com/crigroup/handeye-release;${ROS_BRANCH};protocol=https"
SRCREV = "886615d5491159af8b6fd612a143ec9a05c8e3cc"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
