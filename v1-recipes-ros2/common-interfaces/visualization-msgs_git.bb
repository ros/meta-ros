SUMMARY = "A package containing some visualization and interaction related message definitions."
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=12c26a18c7f493fdc7e8a93b16b7c04f"
DEPENDS = " \
    builtin-interfaces \
    rosidl-default-runtime \
    rosidl-typesupport-cpp \
    ros2-std-msgs \
    ros2-geometry-msgs \
"

ROS_BPN = "visualization_msgs"

include common-interfaces.inc
