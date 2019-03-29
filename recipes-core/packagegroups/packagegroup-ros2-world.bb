DESCRIPTION = "ros2-world package group"
LICENSE = "MIT"

inherit packagegroup

PACKAGES = "${PN}"

RDEPENDS_${PN} = "\
    packagegroup-ros2-demos \
    ros2cli \
    ros2msg \
    ros2run \
    ros2topic \
    ros2pkg \
    ros2node \
    ros2srv \
    ros2service \
    launch \
    actionlib-msgs \
    diagnostic-msgs \
    nav-msgs \
    std-srvs \
    stereo-msgs \
    trajectory-msgs \
    visualization-msgs \
    rosidl-generator-py \
"
