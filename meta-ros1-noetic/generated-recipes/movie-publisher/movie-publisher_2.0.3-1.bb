# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Using a video file as image topic source."
AUTHOR = "Martin Pecka <peckama2@fel.cvut.cz>"
ROS_AUTHOR = "Martin Pecka <peckama2@fel.cvut.cz>"
HOMEPAGE = "https://www.ros.org/wiki/movie_publisher"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=c1feec27682903a4270dbb401e443f91"

ROS_CN = "movie_publisher"
ROS_BPN = "movie_publisher"

ROS_BUILD_DEPENDS = " \
    compass-conversions \
    compass-msgs \
    cras-cpp-common \
    cras-topic-tools \
    ffmpeg \
    gps-common \
    image-geometry \
    image-transport \
    image-transport-codecs \
    muparser \
    nodelet \
    rosbag \
    roscpp \
    sensor-msgs \
    tf2 \
    tf2-geometry-msgs \
    tf2-msgs \
    tf2-ros \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    compass-msgs \
    cras-cpp-common \
    gps-common \
    roscpp \
    sensor-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    compass-conversions \
    compass-msgs \
    cras-bag-tools \
    cras-cpp-common \
    cras-topic-tools \
    ffmpeg \
    gps-common \
    image-geometry \
    image-transport \
    image-transport-codecs \
    muparser \
    nodelet \
    rosbag \
    rosbash-params \
    roscpp \
    rospy \
    sensor-msgs \
    tf2 \
    tf2-geometry-msgs \
    tf2-msgs \
    tf2-ros \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    compressed-image-transport \
    python3-catkin-lint \
    roslaunch \
    roslint \
    rostest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/peci1/movie_publisher-release/archive/release/noetic/movie_publisher/2.0.3-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/movie_publisher"
SRC_URI = "git://github.com/peci1/movie_publisher-release;${ROS_BRANCH};protocol=https"
SRCREV = "db07bb8328d01ee02e0a51be0aa101dc6ab08851"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
