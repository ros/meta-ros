# Copyright (c) 2025 Wind River Systems, Inc.

DESCRIPTION = "Demo packages from Space ROS"
LICENSE = "MIT"

inherit packagegroup
inherit ros_distro_jazzy

PACKAGES = "${PN}"

RDEPENDS:${PN} = "\
    canadarm-demo\
    canadarm-description\
    canadarm-wrench-publisher\
    curiosity-description\
    curiosity-rover-demo\
    ros-trick-bridge\
"
# Temporarily removed from packagegroup
#    canadarm-gazebo
#    canadarm-moveit-config
#    curiosity-gazebo
#    lunar-pole-exploration-rover
#    lunar-sun-gz-plugin
#    lunar-terrain-gz-bringup
#    lunar-terrain-gz-worlds
#    nav2-demo-rviz
#    trick-canadarm-moveit-config
#    trick-ros2-control
