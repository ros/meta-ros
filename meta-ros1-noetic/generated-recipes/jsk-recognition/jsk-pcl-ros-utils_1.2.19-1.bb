# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "ROS utility nodelets for pointcloud perception."
AUTHOR = "Ryohei Ueda <ueda@jsk.t.u-tokyo.ac.jp>"
ROS_AUTHOR = "Yohei Kakiuchi <youhei@jsk.t.u-tokyo.ac.jp>"
HOMEPAGE = "https://jsk-docs.readthedocs.io/projects/jsk_recognition/en/latest/jsk_pcl_ros_utils"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "jsk_recognition"
ROS_BPN = "jsk_pcl_ros_utils"

ROS_BUILD_DEPENDS = " \
    boost \
    cv-bridge \
    diagnostic-msgs \
    diagnostic-updater \
    dynamic-reconfigure \
    eigen-conversions \
    geometry-msgs \
    image-geometry \
    image-transport \
    image-view2 \
    interactive-markers \
    jsk-data \
    jsk-footstep-msgs \
    jsk-recognition-msgs \
    jsk-recognition-utils \
    jsk-topic-tools \
    kdl-conversions \
    kdl-parser \
    laser-assembler \
    message-generation \
    moveit-core \
    moveit-ros-perception \
    nav-msgs \
    nodelet \
    octomap \
    octomap-msgs \
    octomap-ros \
    octomap-server \
    pcl-conversions \
    pcl-msgs \
    pcl-ros \
    python3-pyyaml \
    robot-self-filter \
    ros-environment \
    rosboost-cfg \
    roscpp-tutorials \
    sensor-msgs \
    std-msgs \
    std-srvs \
    stereo-msgs \
    tf \
    tf-conversions \
    tf2-ros \
    visualization-msgs \
    yaml-cpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-python3-sklearn} \
    boost \
    compressed-depth-image-transport \
    compressed-image-transport \
    cv-bridge \
    diagnostic-msgs \
    diagnostic-updater \
    dynamic-reconfigure \
    eigen-conversions \
    geometry-msgs \
    image-geometry \
    image-transport \
    image-view \
    image-view2 \
    interactive-markers \
    jsk-data \
    jsk-footstep-msgs \
    jsk-recognition-msgs \
    jsk-recognition-utils \
    jsk-rviz-plugins \
    jsk-topic-tools \
    kdl-conversions \
    kdl-parser \
    laser-assembler \
    message-runtime \
    moveit-core \
    moveit-ros-perception \
    nav-msgs \
    nodelet \
    octomap \
    octomap-msgs \
    octomap-ros \
    octomap-server \
    openni2-launch \
    pcl-conversions \
    pcl-msgs \
    pcl-ros \
    robot-self-filter \
    rosbag \
    rosboost-cfg \
    roscpp-tutorials \
    rviz \
    sensor-msgs \
    std-msgs \
    std-srvs \
    stereo-msgs \
    tf \
    tf-conversions \
    tf2-ros \
    visualization-msgs \
    yaml-cpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    jsk-perception \
    jsk-tools \
    roslaunch \
    rostest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/tork-a/jsk_recognition-release/archive/release/noetic/jsk_pcl_ros_utils/1.2.19-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/jsk_pcl_ros_utils"
SRC_URI = "git://github.com/tork-a/jsk_recognition-release;${ROS_BRANCH};protocol=https"
SRCREV = "9ee5bc46ec79e2dd8681b33f4833a1aa722e09ec"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
