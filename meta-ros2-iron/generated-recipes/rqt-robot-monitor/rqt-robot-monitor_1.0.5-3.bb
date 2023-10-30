# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_iron
inherit ros_superflore_generated

DESCRIPTION = "rqt_robot_monitor displays diagnostics_agg topics messages that    are published by <a href="http://www.ros.org/wiki/diagnostic_aggregator">diagnostic_aggregator</a>.    rqt_robot_monitor is a direct port to rqt of    <a href="http://www.ros.org/wiki/robot_monitor">robot_monitor</a>. All    diagnostics are fall into one of three tree panes depending on the status of    diagnostics (normal, warning, error/stale). Status are shown in trees to    represent their hierarchy. Worse status dominates the higher level status.<br/>    <ul>     Ex. 'Computer' category has 3 sub devices. 2 are green but 1 is error. Then         'Computer' becomes error.    </ul>   You can look at the detail of each status by double-clicking the tree nodes.<br/>    Currently re-usable API to other pkgs are not explicitly provided."
AUTHOR = "Aaron Blasdel <ablasdel@gmail.com>"
ROS_AUTHOR = "Austin Hendrix"
HOMEPAGE = "http://wiki.ros.org/rqt_robot_monitor"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=27;endline=27;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "rqt_robot_monitor"
ROS_BPN = "rqt_robot_monitor"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    rosidl-default-generators-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    diagnostic-msgs \
    python-qt-binding \
    python3-rospkg \
    qt-gui \
    qt-gui-py-common \
    rclpy \
    rqt-gui \
    rqt-gui-py \
    rqt-py-common \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/rqt_robot_monitor-release/archive/release/iron/rqt_robot_monitor/1.0.5-3.tar.gz
ROS_BRANCH ?= "branch=release/iron/rqt_robot_monitor"
SRC_URI = "git://github.com/ros2-gbp/rqt_robot_monitor-release;${ROS_BRANCH};protocol=https"
SRCREV = "b95afc845652ff1c2bd2b209159f1646983a3afa"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_python"

inherit ros_${ROS_BUILD_TYPE}
