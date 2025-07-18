# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "The omni_base_gazebo package"
AUTHOR = "Andrea Capodacqua <andrea.capodacqua@pal-robotics.com>"
ROS_AUTHOR = "Yue Erro <yue.erro@pal-robotics.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "omni_base_simulation"
ROS_BPN = "omni_base_gazebo"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-auto-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    gazebo-plugins \
    gazebo-ros \
    gazebo-ros2-control \
    launch-pal \
    omni-base-2dnav \
    omni-base-bringup \
    omni-base-description \
    omni-base-laser-sensors \
    pal-gazebo-plugins \
    pal-gazebo-worlds \
    pal-maps \
    ros2launch \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-lint-auto \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/pal-gbp/omni_base_simulation-release/archive/release/humble/omni_base_gazebo/2.8.0-1.tar.gz
ROS_BRANCH ?= "branch=release/humble/omni_base_gazebo"
SRC_URI = "git://github.com/pal-gbp/omni_base_simulation-release;${ROS_BRANCH};protocol=https"
SRCREV = "1686d8428699bb4002b39eceecadb3a617fde653"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
