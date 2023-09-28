# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "A ROS node and assorted tools to provide access to the WGE100     camera used in the forearms and the stereo cameras of the PR2     robot."
AUTHOR = "Austin Hendrix <ahendrix@willowgarage.com>"
ROS_AUTHOR = "Blaise Gassend, Patrick Mihelich, Eric MacIntosh, David Palchak"
HOMEPAGE = "http://www.ros.org/wiki/wge100_camera"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "GPL because of list.h; other files released under 0BSD"
LICENSE = "GPL-because-of-list.h-&-other-files-released-under-BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=984eb2ebe444619cdde9621008ccf4e4"

ROS_CN = "wge100_driver"
ROS_BPN = "wge100_camera"

ROS_BUILD_DEPENDS = " \
    camera-calibration-parsers \
    diagnostic-updater \
    driver-base \
    dynamic-reconfigure \
    image-transport \
    message-generation \
    roscpp \
    rospy \
    rostest \
    self-test \
    sensor-msgs \
    std-msgs \
    timestamp-tools \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    camera-calibration-parsers \
    diagnostic-updater \
    driver-base \
    dynamic-reconfigure \
    image-transport \
    message-runtime \
    roscpp \
    rospy \
    self-test \
    sensor-msgs \
    std-msgs \
    timestamp-tools \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    camera-calibration-parsers \
    diagnostic-updater \
    driver-base \
    dynamic-reconfigure \
    image-transport \
    message-runtime \
    roscpp \
    rospy \
    self-test \
    sensor-msgs \
    std-msgs \
    timestamp-tools \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-drivers-gbp/wge100_driver-release/archive/release/melodic/wge100_camera/1.8.2-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/wge100_camera"
SRC_URI = "git://github.com/ros-drivers-gbp/wge100_driver-release;${ROS_BRANCH};protocol=https"
SRCREV = "52129177525d98268a3e6e34e01eb9c6bc1cdb5d"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
