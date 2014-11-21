DESCRIPTION = "The gripper_action_controller package"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=16;endline=16;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "actionlib angles cmake-modules roscpp urdf control-toolbox controller-interface \
    hardware-interface realtime-tools control-msgs trajectory-msgs controller-manager xacro"

require ros-controllers.inc
