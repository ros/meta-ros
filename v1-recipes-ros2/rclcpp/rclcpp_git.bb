SUMMARY = "The ROS client library in C++."
HOMEPAGE = "https://github.com/ros2/rcl_interfaces"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=12c26a18c7f493fdc7e8a93b16b7c04f"
DEPENDS = " \
    builtin-interfaces \
    rosidl-default-runtime \
    rcl \
"

SRCREV = "bea1a52e24eaea0ad141a4d13dfa4606fcf190e7"
SRC_URI = "git://github.com/ros2/rclcpp.git;protocol=git;"

inherit ament pythonpath-insane
