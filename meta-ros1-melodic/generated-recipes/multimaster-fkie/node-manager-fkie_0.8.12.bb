# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "Graphical interface, written in PySide, to manage the running and       configured ROS nodes on different hosts. For discovering       the running ROS master master_discovery node will be used."
AUTHOR = "Alexander Tiderko <alexander.tiderko@gmail.com>"
ROS_AUTHOR = "Alexander Tiderko"
HOMEPAGE = "http://ros.org/wiki/node_manager_fkie"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "BSD, some icons are licensed under the GNU Lesser General Public License (LGPL) or Creative Commons Attribution-Noncommercial 3.0 License"
LICENSE = "BSD-&-some-icons-are-licensed-under-LGPL-or-CC-BY-NC-3.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=261b66671071bbaa4ac3e568151c48bc"

ROS_CN = "multimaster_fkie"
ROS_BPN = "node_manager_fkie"

ROS_BUILD_DEPENDS = " \
    diagnostic-msgs \
    master-discovery-fkie \
    multimaster-msgs-fkie \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    ${PYTHON_PN}-paramiko \
    ${ROS_UNRESOLVED_DEP-python-docutils} \
    default-cfg-fkie \
    diagnostic-msgs \
    dynamic-reconfigure \
    master-discovery-fkie \
    master-sync-fkie \
    multimaster-msgs-fkie \
    python-qt-binding \
    rosgraph \
    roslaunch \
    roslib \
    rosmsg \
    rospy \
    rosservice \
    rqt-gui \
    rqt-reconfigure \
    screen \
    xterm \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${PYTHON_PN}-paramiko \
    ${ROS_UNRESOLVED_DEP-python-docutils} \
    default-cfg-fkie \
    diagnostic-msgs \
    dynamic-reconfigure \
    master-discovery-fkie \
    master-sync-fkie \
    multimaster-msgs-fkie \
    python-qt-binding \
    rosgraph \
    roslaunch \
    roslib \
    rosmsg \
    rospy \
    rosservice \
    rqt-gui \
    rqt-reconfigure \
    screen \
    xterm \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/fkie-release/multimaster_fkie-release/archive/release/melodic/node_manager_fkie/0.8.12-0.tar.gz
ROS_BRANCH ?= "branch=release/melodic/node_manager_fkie"
SRC_URI = "git://github.com/fkie-release/multimaster_fkie-release;${ROS_BRANCH};protocol=https"
SRCREV = "0b9465c8f877051a53e25e34fd7cf3caec2c1b1b"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
