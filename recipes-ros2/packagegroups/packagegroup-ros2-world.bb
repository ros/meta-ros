DESCRIPTION = "ros2-world package group"
LICENSE = "MIT"

inherit packagegroup

PACKAGES = "${PN}"

RDEPENDS_${PN} = "\
    packagegroup-ros2-demos \
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
