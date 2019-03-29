SUMMARY = "The ROS client library common implementation."
HOMEPAGE = "https://github.com/ros2/rcl_interfaces"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=12c26a18c7f493fdc7e8a93b16b7c04f"
DEPENDS = " \
    ament-cmake-ros \
    rcl-interfaces \
    rmw-implementation \
"

SRCREV = "b41d4e333e2b977f7c93a18009cd93a8db5e87f0"
SRC_URI = "git://github.com/ros2/rcl.git;protocol=git;"

inherit ament
