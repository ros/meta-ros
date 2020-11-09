# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "The VisualStates is reactive hierarchical visual robot planning tool."
AUTHOR = "Okan Aşık <asik.okan@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "GPLv3"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=1e7b3bcc2e271699c77c769685058cbe"

ROS_CN = "visualstates"
ROS_BPN = "visualstates"

ROS_BUILD_DEPENDS = " \
    roscpp \
    rospy \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    ${PYTHON_PN}-pyqt5 \
    ${PYTHON_PN}-rospkg \
    roscpp \
    rospy \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${PYTHON_PN}-pyqt5 \
    ${PYTHON_PN}-rospkg \
    roscpp \
    rospy \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/JdeRobot/VisualStates-release/archive/release/melodic/visualstates/0.2.4-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/visualstates"
SRC_URI = "git://github.com/JdeRobot/VisualStates-release;${ROS_BRANCH};protocol=https"
SRCREV = "b70bb5d2083cb650e68ab33858661194efcbe24c"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
