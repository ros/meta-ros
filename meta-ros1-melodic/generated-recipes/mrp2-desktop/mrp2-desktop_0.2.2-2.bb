# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "Visualization tools and configurations for MRP2 robot."
AUTHOR = "Akif Hacinecipoglu <akifhno@gmail.com>"
ROS_AUTHOR = "Akif Hacinecipoglu <akifhno@gmail.com>"
HOMEPAGE = "http://wiki.ros.org/mrp2_desktop"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "mrp2_desktop"
ROS_BPN = "mrp2_desktop"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    mrp2-viz \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    mrp2-viz \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/milvusrobotics/mrp2_desktop-release/archive/release/melodic/mrp2_desktop/0.2.2-2.tar.gz
ROS_BRANCH ?= "branch=release/melodic/mrp2_desktop"
SRC_URI = "git://github.com/milvusrobotics/mrp2_desktop-release;${ROS_BRANCH};protocol=https"
SRCREV = "c7ebe38e3152bf55d8e20d7beb8fa1549bf75ee5"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
