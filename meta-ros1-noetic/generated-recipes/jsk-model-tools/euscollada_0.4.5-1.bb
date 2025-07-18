# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "euscollada"
AUTHOR = "Yohei Kakiuchi <youhei@jsk.t.u-tokyo.ac.jp>"
ROS_AUTHOR = "Kei Okada <k-okada@jsk.t.u-tokyo.ac.jp>"
HOMEPAGE = "http://ros.org/wiki/euscollada"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "jsk_model_tools"
ROS_BPN = "euscollada"

ROS_BUILD_DEPENDS = " \
    assimp-devel \
    cmake-modules \
    collada-dom \
    collada-parser \
    collada-urdf \
    mk \
    qhull \
    resource-retriever \
    rosboost-cfg \
    rosbuild \
    roscpp \
    rospack \
    rostest \
    tf \
    urdf \
    urdfdom \
    yaml-cpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    assimp-devel \
    collada-dom \
    collada-parser \
    collada-urdf \
    qhull \
    resource-retriever \
    roscpp \
    rospack \
    rostest \
    tf \
    urdf \
    urdfdom \
    yaml-cpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    assimp-devel \
    collada-dom \
    collada-parser \
    collada-urdf \
    qhull \
    resource-retriever \
    roscpp \
    rospack \
    rostest \
    tf \
    urdf \
    urdfdom \
    yaml-cpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    openhrp3 \
    pr2-description \
    roseus \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/tork-a/jsk_model_tools-release/archive/release/noetic/euscollada/0.4.5-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/euscollada"
SRC_URI = "git://github.com/tork-a/jsk_model_tools-release;${ROS_BRANCH};protocol=https"
SRCREV = "f8504cdd5be2c8c20c87860c470db42379c2e133"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
