# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "fmt is an open-source formatting library for C++. 		It can be used as a safe and fast alternative to (s)printf and IOStreams."
AUTHOR = "Max Schwarz <max.schwarz@ais.uni-bonn.de>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=75730354549103aaba72b66caf53717b"

ROS_CN = "rosfmt"
ROS_BPN = "rosfmt"

ROS_BUILD_DEPENDS = " \
    rosconsole \
    roscpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    rosconsole \
    roscpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    rosconsole \
    roscpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/xqms/rosfmt-release/archive/release/melodic/rosfmt/7.0.0-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/rosfmt"
SRC_URI = "git://github.com/xqms/rosfmt-release;${ROS_BRANCH};protocol=https"
SRCREV = "8a442dda26c630af11df01394e64371f0b2956c5"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
