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
#    canadarm-gazebo
#    curiosity-gazebo
#    trick-canadarm-moveit-config
#    trick-ros2-control
#    canadarm-moveit-config
