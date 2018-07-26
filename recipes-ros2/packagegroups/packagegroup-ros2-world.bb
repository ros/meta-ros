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
    ros2-launch \
    ros2-actionlib-msgs \
    ros2-diagnostic-msgs \
    ros2-nav-msgs \
    ros2-std-srvs \
    ros2-stereo-msgs \
    ros2-trajectory-msgs \
    ros2-visualization-msgs \
    rosidl-generator-py \
"
