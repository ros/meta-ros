# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "Provides nonlinear state estimation through sensor fusion of an abritrary number of sensors."
AUTHOR = "Tom Moore <ayrton04@gmail.com>"
ROS_AUTHOR = "Tom Moore <ayrton04@gmail.com>"
HOMEPAGE = "http://ros.org/wiki/robot_localization"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "robot_localization"
ROS_BPN = "robot_localization"

ROS_BUILD_DEPENDS = " \
    ${PYTHON_PN}-catkin-pkg \
    cmake-modules \
    diagnostic-msgs \
    diagnostic-updater \
    eigen-conversions \
    geographic-msgs \
    geographiclib \
    geometry-msgs \
    libeigen \
    message-filters \
    message-generation \
    nav-msgs \
    nodelet \
    roscpp \
    roslint \
    sensor-msgs \
    std-msgs \
    std-srvs \
    tf2 \
    tf2-geometry-msgs \
    tf2-ros \
    yaml-cpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    cmake-modules \
    diagnostic-msgs \
    diagnostic-updater \
    eigen-conversions \
    geographic-msgs \
    geometry-msgs \
    libeigen \
    message-filters \
    nav-msgs \
    nodelet \
    roscpp \
    sensor-msgs \
    std-msgs \
    std-srvs \
    tf2 \
    tf2-geometry-msgs \
    tf2-ros \
    yaml-cpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    cmake-modules \
    diagnostic-msgs \
    diagnostic-updater \
    eigen-conversions \
    geographic-msgs \
    geometry-msgs \
    libeigen \
    message-filters \
    message-runtime \
    nav-msgs \
    nodelet \
    roscpp \
    sensor-msgs \
    std-msgs \
    std-srvs \
    tf2 \
    tf2-geometry-msgs \
    tf2-ros \
    yaml-cpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    rosbag \
    rostest \
    rosunit \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/cra-ros-pkg/robot_localization-release/archive/release/melodic/robot_localization/2.6.11-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/robot_localization"
SRC_URI = "git://github.com/cra-ros-pkg/robot_localization-release;${ROS_BRANCH};protocol=https"
SRCREV = "ba3de9697cd4186f7c23f8e7a7219b4ba06844d2"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
