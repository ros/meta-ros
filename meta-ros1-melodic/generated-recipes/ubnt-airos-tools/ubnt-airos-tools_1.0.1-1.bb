# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "Ubiquiti AirOS tools for extracting AP information to ROS"
AUTHOR = "Martin Pecka <peckama2@fel.cvut.cz>"
ROS_AUTHOR = "Martin Pecka <peckama2@fel.cvut.cz>"
HOMEPAGE = "https://github.com/peci1/ubnt_airos_tools"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "ubnt_airos_tools"
ROS_BPN = "ubnt_airos_tools"

ROS_BUILD_DEPENDS = " \
    message-generation \
    message-runtime \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    message-runtime \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${PYTHON_PN}-requests \
    rospy \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/peci1/ubnt_airos_tools-release/archive/release/melodic/ubnt_airos_tools/1.0.1-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/ubnt_airos_tools"
SRC_URI = "git://github.com/peci1/ubnt_airos_tools-release;${ROS_BRANCH};protocol=https"
SRCREV = "5503c6d4af58b915fbeb06b90bb1edd0a291a1fe"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
