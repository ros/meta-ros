# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Node for the Color Machine Vision Project, used for fast color blob detection"
AUTHOR = "Piyush Khandelwal <piyushk@gmail.com>"
ROS_AUTHOR = "Nate Koenig"
HOMEPAGE = "http://ros.org/wiki/cmvision"
SECTION = "devel"
LICENSE = "LGPL"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=46ee8693f40a89a31023e97ae17ecf19"

ROS_CN = "cmvision"
ROS_BPN = "cmvision"

ROS_BUILD_DEPENDS = " \
    cv-bridge \
    fltk \
    message-generation \
    roscpp \
    sensor-msgs \
    std-msgs \
    wxwidgets \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    cv-bridge \
    fltk \
    message-runtime \
    roscpp \
    sensor-msgs \
    std-msgs \
    wxwidgets \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    cv-bridge \
    fltk \
    message-runtime \
    roscpp \
    sensor-msgs \
    std-msgs \
    wxwidgets \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/teshanshanuka/cmvision-release/archive/release/noetic/cmvision/0.5.0-2.tar.gz
ROS_BRANCH ?= "branch=release/noetic/cmvision"
SRC_URI = "git://github.com/teshanshanuka/cmvision-release;${ROS_BRANCH};protocol=https"
SRCREV = "2a20f6df9efcc966fb50ba5946afdca2a878aac9"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
