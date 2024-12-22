# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "ROS2 Navigation Stack"
AUTHOR = "Steve Macenski <stevenmacenski@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=82f0323c08605e5b6f343b05213cf7cc"

ROS_CN = "navigation2"
ROS_BPN = "navigation2"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    nav2-amcl \
    nav2-behavior-tree \
    nav2-behaviors \
    nav2-bt-navigator \
    nav2-collision-monitor \
    nav2-constrained-smoother \
    nav2-controller \
    nav2-core \
    nav2-costmap-2d \
    nav2-dwb-controller \
    nav2-lifecycle-manager \
    nav2-map-server \
    nav2-mppi-controller \
    nav2-msgs \
    nav2-navfn-planner \
    nav2-planner \
    nav2-regulated-pure-pursuit-controller \
    nav2-rotation-shim-controller \
    nav2-rviz-plugins \
    nav2-simple-commander \
    nav2-smac-planner \
    nav2-smoother \
    nav2-theta-star-planner \
    nav2-util \
    nav2-velocity-smoother \
    nav2-voxel-grid \
    nav2-waypoint-follower \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/SteveMacenski/navigation2-release/archive/release/humble/navigation2/1.1.16-1.tar.gz
ROS_BRANCH ?= "branch=release/humble/navigation2"
SRC_URI = "git://github.com/SteveMacenski/navigation2-release;${ROS_BRANCH};protocol=https"
SRCREV = "cdd0645793febcbf06b725fd9497e6a355697f2b"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
