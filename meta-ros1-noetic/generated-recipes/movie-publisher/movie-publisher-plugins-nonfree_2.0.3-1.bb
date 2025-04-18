# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "movie_publisher metadata plugins with nonfree licenses. exiftool is free for personal use."
AUTHOR = "Martin Pecka <peckama2@fel.cvut.cz>"
ROS_AUTHOR = "Martin Pecka <peckama2@fel.cvut.cz>"
HOMEPAGE = "https://wiki.ros.org/movie_publisher"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=a56578d5ab2837de9a457d4165772535"

ROS_CN = "movie_publisher"
ROS_BPN = "movie_publisher_plugins_nonfree"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    exiftool-metadata-extractor \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/peci1/movie_publisher-release/archive/release/noetic/movie_publisher_plugins_nonfree/2.0.3-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/movie_publisher_plugins_nonfree"
SRC_URI = "git://github.com/peci1/movie_publisher-release;${ROS_BRANCH};protocol=https"
SRCREV = "76e6d80bed17dc57caaa22460c0ccd1830229df3"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
