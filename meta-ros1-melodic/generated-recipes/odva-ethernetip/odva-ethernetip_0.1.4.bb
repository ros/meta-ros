# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "Library implementing ODVA EtherNet/IP (Industrial Protocol)."
AUTHOR = "Mike Purvis <mpurvis@clearpathrobotics.com>"
ROS_AUTHOR = "Kareem Shehata <kareem@shehata.ca>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "odva_ethernetip"
ROS_BPN = "odva_ethernetip"

ROS_BUILD_DEPENDS = " \
    boost \
    console-bridge \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    boost \
    console-bridge \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    boost \
    console-bridge \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    rosunit \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-drivers-gbp/odva_ethernetip-release/archive/release/melodic/odva_ethernetip/0.1.4-0.tar.gz
ROS_BRANCH ?= "branch=release/melodic/odva_ethernetip"
SRC_URI = "git://github.com/ros-drivers-gbp/odva_ethernetip-release;${ROS_BRANCH};protocol=https"
SRCREV = "78d8eccd42436befbd9aeb83b6062e07a49e162b"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
