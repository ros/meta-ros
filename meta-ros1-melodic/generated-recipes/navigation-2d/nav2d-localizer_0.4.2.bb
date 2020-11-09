# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "Wrapper around Particle Filter implementation.     The SelfLocalizer can be used as library or as a ros-node."
AUTHOR = "Sebastian Kasperski <sebastian.kasperski@dfki.de>"
ROS_AUTHOR = "Sebastian Kasperski <sebastian.kasperski@dfki.de>"
HOMEPAGE = "http://wiki.ros.org/self_localizer"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "GPLv3"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=1e7b3bcc2e271699c77c769685058cbe"

ROS_CN = "navigation_2d"
ROS_BPN = "nav2d_localizer"

ROS_BUILD_DEPENDS = " \
    geometry-msgs \
    nav-msgs \
    roscpp \
    sensor-msgs \
    tf \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    geometry-msgs \
    nav-msgs \
    roscpp \
    sensor-msgs \
    tf \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geometry-msgs \
    nav-msgs \
    roscpp \
    sensor-msgs \
    tf \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/skasperski/navigation_2d-release/archive/release/melodic/nav2d_localizer/0.4.2-0.tar.gz
ROS_BRANCH ?= "branch=release/melodic/nav2d_localizer"
SRC_URI = "git://github.com/skasperski/navigation_2d-release;${ROS_BRANCH};protocol=https"
SRCREV = "e732397b5a31e5d3aff19d949e0d103603ebdff5"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
