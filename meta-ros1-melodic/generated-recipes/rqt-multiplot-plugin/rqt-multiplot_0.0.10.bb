# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "rqt_multiplot provides a GUI plugin for visualizing numeric values     in multiple 2D plots using the Qwt plotting backend."
AUTHOR = "Ralf Kaestner <ralf.kaestner@gmail.com>"
ROS_AUTHOR = "Ralf Kaestner"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "GNU Lesser General Public License (LGPL)"
LICENSE = "GNU-Lesser-General-Public-License-LGPL-"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=146ba316845cfe6058c8baebd902a726"

ROS_CN = "rqt_multiplot_plugin"
ROS_BPN = "rqt_multiplot"

ROS_BUILD_DEPENDS = " \
    qtbase \
    qwt-qt5 \
    rosbag \
    roscpp \
    rqt-gui \
    rqt-gui-cpp \
    variant-topic-tools \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    qtbase \
    qwt-qt5 \
    rosbag \
    roscpp \
    rqt-gui \
    rqt-gui-cpp \
    variant-topic-tools \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    qtbase \
    qwt-qt5 \
    rosbag \
    roscpp \
    rqt-gui \
    rqt-gui-cpp \
    variant-topic-tools \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/anybotics/rqt_multiplot_plugin-release/archive/release/melodic/rqt_multiplot/0.0.10-0.tar.gz
ROS_BRANCH ?= "branch=release/melodic/rqt_multiplot"
SRC_URI = "git://github.com/anybotics/rqt_multiplot_plugin-release;${ROS_BRANCH};protocol=https"
SRCREV = "890b0183dd413c19d262447de004e70f23b03cee"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
