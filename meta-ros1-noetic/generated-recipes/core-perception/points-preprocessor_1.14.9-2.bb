# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "The points_preprocessor package"
AUTHOR = "amc-nu <abrahammonrroy@yahoo.com>"
ROS_AUTHOR = "n-patiphon <n.patiphon@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache 2"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=fc216ef9336537897fbeafa564601763"

ROS_CN = "core_perception"
ROS_BPN = "points_preprocessor"

ROS_BUILD_DEPENDS = " \
    autoware-config-msgs \
    cv-bridge \
    gtest \
    message-filters \
    pcl-conversions \
    pcl-ros \
    qtbase \
    roscpp \
    roslint \
    rostest \
    sensor-msgs \
    std-msgs \
    tf \
    tf2 \
    tf2-eigen \
    tf2-ros \
    velodyne-pointcloud \
    yaml-cpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    autoware-config-msgs \
    cv-bridge \
    gtest \
    message-filters \
    pcl-conversions \
    pcl-ros \
    qtbase \
    roscpp \
    roslint \
    rostest \
    sensor-msgs \
    std-msgs \
    tf \
    tf2 \
    tf2-eigen \
    tf2-ros \
    velodyne-pointcloud \
    yaml-cpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    autoware-config-msgs \
    cv-bridge \
    gtest \
    message-filters \
    pcl-conversions \
    pcl-ros \
    qtbase \
    roscpp \
    roslint \
    rostest \
    sensor-msgs \
    std-msgs \
    tf \
    tf2 \
    tf2-eigen \
    tf2-ros \
    velodyne-pointcloud \
    yaml-cpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/nobleo/core_perception-release/archive/release/noetic/points_preprocessor/1.14.9-2.tar.gz
ROS_BRANCH ?= "branch=release/noetic/points_preprocessor"
SRC_URI = "git://github.com/nobleo/core_perception-release;${ROS_BRANCH};protocol=https"
SRCREV = "3c6a61fe17050ded14259be6565c46c82e08b275"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
