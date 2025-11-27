# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "A package for easy creation and reading of PointCloud2 messages in Python."
AUTHOR = "Tully Foote <tfoote@openrobotics.org>"
ROS_AUTHOR = "Geoffrey Biggs <geoff@openrobotics.org>"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "common_interfaces"
ROS_BPN = "sensor_msgs_py"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = ""

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    python3-numpy\
    sensor-msgs\
    std-msgs\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-copyright\
    ament-flake8\
    ament-pep257\
    python3-pytest\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=jazzy"
SRC_URI = "git://github.com/ros2/common_interfaces.git;${ROS_BRANCH};protocol=https"
SRCREV = "137e97dc5ec724b78cdbaa3b89927c3c29f81f02"
S = "${WORKDIR}/git/sensor_msgs_py"

ROS_BUILD_TYPE = "ament_python"

inherit ros_${ROS_BUILD_TYPE}
