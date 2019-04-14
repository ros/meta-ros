SUMMARY = "A meta-package for all ROS2 common interfaces."
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=12c26a18c7f493fdc7e8a93b16b7c04f"
RDEPENDS_${PN} = " \
    builtin-interfaces \
    ros2-actionlib-msgs \
    ros2-diagnostic-msgs \
    ros2-geometry-msgs \
    ros2-nav-msgs \
    ros2-sensor-msgs \
    ros2-shape-msgs \
    ros2-std-msgs \
    ros2-stereo-msgs \
    ros2-trajectory-msgs \
    ros2-visualization-msgs \
"

ROS_BPN = "common_interfaces"

include common-interfaces.inc
