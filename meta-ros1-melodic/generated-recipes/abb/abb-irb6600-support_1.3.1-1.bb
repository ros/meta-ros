# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "<p>       ROS-Industrial support for the ABB IRB 6600 (and variants).     </p>     <p>       This package contains configuration data, 3D models and launch files       for ABB IRB 6600 manipulators. This currently includes the base model.     </p>     <p>       Joint limits and max joint velocities are based on the information in       the ABB data sheets.  All URDFs / XACROs are based on the       default motion and joint velocity limits, unless noted otherwise (ie:       no support for high speed joints, extended / limited motion ranges or       other options).     </p>     <p>       Before using any of the configuration files and / or meshes included       in this package, be sure to check they are correct for the particular       robot model and configuration you intend to use them with.     </p>     <p>       The unqualified IRB 6400 model will be removed in ROS-Lunar, please       use the abb_irb6640_support as a replacement.     </p>"
AUTHOR = "Levi Armstrong (Southwest Research Institute) <levi.armstrong@swri.org>"
ROS_AUTHOR = "Dan Solomon (Southwest Research Institute)"
HOMEPAGE = "http://ros.org/wiki/abb_irb6600_support"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=32;endline=32;md5=c93e37fc0c6f510db5735eb91dcc1550"

ROS_CN = "abb"
ROS_BPN = "abb_irb6600_support"

ROS_BUILD_DEPENDS = " \
    roslaunch \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    abb-driver \
    joint-state-publisher \
    robot-state-publisher \
    rviz \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-industrial-release/abb-release/archive/release/melodic/abb_irb6600_support/1.3.1-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/abb_irb6600_support"
SRC_URI = "git://github.com/ros-industrial-release/abb-release;${ROS_BRANCH};protocol=https"
SRCREV = "5805264f6ad176e48163ce41133196183d2711be"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
