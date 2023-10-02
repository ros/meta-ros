# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "A metapackage to aggregate the packages required to use publish / subscribe, services, launch files, and other core ROS concepts."
AUTHOR = "Mikael Arguedas <mikael@osrfoundation.org>"
ROS_AUTHOR = "Dirk Thomas"
HOMEPAGE = "https://github.com/ros/metapackages"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "metapackages"
ROS_BPN = "ros_core"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    catkin \
    class-loader \
    cmake-modules \
    common-msgs \
    gencpp \
    geneus \
    genlisp \
    genmsg \
    gennodejs \
    genpy \
    message-generation \
    message-runtime \
    pluginlib \
    ros \
    ros-comm \
    rosbag-migration-rule \
    rosconsole \
    rosconsole-bridge \
    roscpp-core \
    rosgraph-msgs \
    roslisp \
    rospack \
    std-msgs \
    std-srvs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/metapackages-release/archive/release/noetic/ros_core/1.5.0-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/ros_core"
SRC_URI = "git://github.com/ros-gbp/metapackages-release;${ROS_BRANCH};protocol=https"
SRCREV = "a467c47111e0f29ba6d1edee47437be9c454c060"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
