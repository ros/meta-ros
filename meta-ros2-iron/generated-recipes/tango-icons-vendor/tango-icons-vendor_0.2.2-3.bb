# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_iron
inherit ros_superflore_generated

DESCRIPTION = "tango_icons_vendor provides the public domain Tango icons for non-linux systems (<a href="http://tango-project.org/Tango_Icon_Library/">Tango Icon Library</a>) from the <a href="http://tango-project.org/Tango_Desktop_Project/">Tango Desktop Project</a>"
AUTHOR = "Scott K Logan <scott@openrobotics.org>"
ROS_AUTHOR = "Alejandro Hernandez <alejandro@osrfoundation.org>"
HOMEPAGE = "http://ros.org/wiki/qt_gui_icons"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License 2.0 & Public Domain"
LICENSE = "Apache-2.0 & PD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=f12ef8c0445c08084ae92cf2dcb7ee92"

ROS_CN = "tango_icons_vendor"
ROS_BPN = "tango_icons_vendor"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    adwaita-icon-theme \
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

# matches with: https://github.com/ros2-gbp/tango_icons_vendor-release/archive/release/iron/tango_icons_vendor/0.2.2-3.tar.gz
ROS_BRANCH ?= "branch=release/iron/tango_icons_vendor"
SRC_URI = "git://github.com/ros2-gbp/tango_icons_vendor-release;${ROS_BRANCH};protocol=https"
SRCREV = "012ef5e1a8dc3330f34f8209ff7cddc3a8b33977"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
