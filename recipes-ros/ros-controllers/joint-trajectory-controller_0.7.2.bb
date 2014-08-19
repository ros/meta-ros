DESCRIPTION = "Controller for executing joint-space trajectories on a group of joints."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "actionlib angles cmake-modules control-toolbox controller-interface controller-manager control-msgs urdf xacro"

require ros-controllers.inc

SRC_URI += "file://0001-check-for-CATKIN_ENABLE_TESTING.patch;striplevel=2 \
    file://0001-joint_trajectory_controller-make-rostest-in-CMakeLis.patch;striplevel=2"
