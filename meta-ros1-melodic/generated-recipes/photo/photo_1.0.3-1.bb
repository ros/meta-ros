# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "The photo package provides access to digital cameras. Much of the underlying functionality is provide by the gPhoto libary. The system package libgphoto2-2-dev or equivalent is required.&gt;"
AUTHOR = "Philip Roan <Philip.Roan@us.bosch.com>"
ROS_AUTHOR = "Benjamin Pitzer"
HOMEPAGE = "http://wiki.ros.org/photo"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "photo"
ROS_BPN = "photo"

ROS_BUILD_DEPENDS = " \
    libgphoto2 \
    message-generation \
    opencv \
    roscpp \
    self-test \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    libgphoto2 \
    message-runtime \
    opencv \
    roscpp \
    self-test \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    libgphoto2 \
    message-runtime \
    opencv \
    roscpp \
    self-test \
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

# matches with: https://github.com/bosch-ros-pkg/photo-release/archive/release/melodic/photo/1.0.3-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/photo"
SRC_URI = "git://github.com/bosch-ros-pkg/photo-release;${ROS_BRANCH};protocol=https"
SRCREV = "5b2ddc42a330be5de4d88e6ec8ded972ec67a03b"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
