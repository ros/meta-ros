DESCRIPTION = "A ROS camera driver that uses gstreamer to connect to devices such as webcams."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "gstreamer gst-plugins-base gst-plugins-good nodelet opencv roscpp image-transport sensor-msgs \
    camera-calibration-parsers camera-info-manager"

SRC_URI = "https://github.com/ros-drivers/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "b0512882e06f5cdd4c6015f16dceb346"
SRC_URI[sha256sum] = "84d02ed9a0bed769bebddfb67d27085ae779aaf9ab1311aaad94e9d17aa0fbc6"

inherit catkin
