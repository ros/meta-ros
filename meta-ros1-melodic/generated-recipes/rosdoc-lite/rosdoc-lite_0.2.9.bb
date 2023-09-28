# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "This ROS package wraps documentation tools like doxygen, sphinx,     and epydoc, making it convenient to generate ROS package     documentation.      It also generates online documentation for the ROS wiki."
AUTHOR = "Jack O'Quin <jack.oquin@gmail.com>"
ROS_AUTHOR = "Ken Conley"
HOMEPAGE = "http://wiki.ros.org/rosdoc_lite"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "rosdoc_lite"
ROS_BPN = "rosdoc_lite"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    ${PYTHON_PN}-catkin-pkg \
    ${PYTHON_PN}-pyyaml \
    ${PYTHON_PN}-rospkg \
    ${PYTHON_PN}-sphinx \
    ${ROS_UNRESOLVED_DEP-epydoc} \
    ${ROS_UNRESOLVED_DEP-python-kitchen} \
    doxygen \
    genmsg \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${PYTHON_PN}-catkin-pkg \
    ${PYTHON_PN}-pyyaml \
    ${PYTHON_PN}-rospkg \
    ${PYTHON_PN}-sphinx \
    ${ROS_UNRESOLVED_DEP-epydoc} \
    ${ROS_UNRESOLVED_DEP-python-kitchen} \
    doxygen \
    genmsg \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/rosdoc_lite-release/archive/release/melodic/rosdoc_lite/0.2.9-0.tar.gz
ROS_BRANCH ?= "branch=release/melodic/rosdoc_lite"
SRC_URI = "git://github.com/ros-gbp/rosdoc_lite-release;${ROS_BRANCH};protocol=https"
SRCREV = "ea4bb809b01f3225de6c4e8696be6700aeb468e1"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
