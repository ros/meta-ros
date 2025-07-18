# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Metadata extractor utilizing exiv2 library."
AUTHOR = "Martin Pecka <peckama2@fel.cvut.cz>"
ROS_AUTHOR = "Martin Pecka <peckama2@fel.cvut.cz>"
HOMEPAGE = "https://wiki.ros.org/exiv2_metadata_extractor"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "BSD & GPLv2"
LICENSE = "BSD & GPL-2.0-only"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=c1feec27682903a4270dbb401e443f91"

ROS_CN = "movie_publisher"
ROS_BPN = "exiv2_metadata_extractor"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-libexiv2-dev} \
    cras-cpp-common \
    movie-publisher \
    pluginlib \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-exiv2} \
    cras-cpp-common \
    movie-publisher \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    python3-catkin-lint \
    roslint \
    rostest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/peci1/movie_publisher-release/archive/release/noetic/exiv2_metadata_extractor/3.0.2-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/exiv2_metadata_extractor"
SRC_URI = "git://github.com/peci1/movie_publisher-release;${ROS_BRANCH};protocol=https"
SRCREV = "5a79f79453450deb4e1d7da594274074bd90e5a9"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
