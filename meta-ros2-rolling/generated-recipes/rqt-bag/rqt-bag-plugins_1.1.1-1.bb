# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_rolling
inherit ros_superflore_generated

DESCRIPTION = "rqt_bag provides a GUI plugin for displaying and replaying ROS bag files."
AUTHOR = "Mabel Zhang <mabel@openrobotics.org>"
ROS_AUTHOR = "Dirk Thomas <dthomas@osrfoundation.org>"
HOMEPAGE = "http://wiki.ros.org/rqt_bag"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "rqt_bag"
ROS_BPN = "rqt_bag_plugins"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = ""

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geometry-msgs \
    python3-pillow \
    python3-pycairo \
    rclpy \
    rosbag2 \
    rqt-bag \
    rqt-gui \
    rqt-gui-py \
    rqt-plot \
    sensor-msgs \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/rqt_bag-release/archive/release/rolling/rqt_bag_plugins/1.1.1-1.tar.gz
ROS_BRANCH ?= "branch=release/rolling/rqt_bag_plugins"
SRC_URI = "git://github.com/ros2-gbp/rqt_bag-release;${ROS_BRANCH};protocol=https"
SRCREV = "9e9b47830e78a237b4786faf92208ec4b69ebe63"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_python"

inherit ros_${ROS_BUILD_TYPE}
