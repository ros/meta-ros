# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "Extract a single ring of a Velodyne PointCloud2 and publish it as a LaserScan message"
AUTHOR = "Josh Whitley <jwhitley@autonomoustuff.com>"
ROS_AUTHOR = "Micho Radovnikovich"
HOMEPAGE = "http://ros.org/wiki/velodyne_laserscan"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "velodyne"
ROS_BPN = "velodyne_laserscan"

ROS_BUILD_DEPENDS = " \
    dynamic-reconfigure \
    nodelet \
    roscpp \
    sensor-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    dynamic-reconfigure \
    nodelet \
    roscpp \
    sensor-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    dynamic-reconfigure \
    nodelet \
    roscpp \
    sensor-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    roslaunch \
    rostest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-drivers-gbp/velodyne-release/archive/release/melodic/velodyne_laserscan/1.5.2-0.tar.gz
ROS_BRANCH ?= "branch=release/melodic/velodyne_laserscan"
SRC_URI = "git://github.com/ros-drivers-gbp/velodyne-release;${ROS_BRANCH};protocol=https"
SRCREV = "cfd1099dc0352be624c782bcd9d023f80f70bfae"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
