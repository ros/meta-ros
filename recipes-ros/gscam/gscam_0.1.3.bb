DESCRIPTION = "A ROS camera driver that uses gstreamer to connect to devices such as webcams."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "gstreamer gst-plugins-base nodelet opencv roscpp image-transport sensor-msgs \
  camera-calibration-parsers camera-info-manager"

SRC_URI = "https://github.com/ros-drivers/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "c20617a0db24124168fe968365ecb990"
SRC_URI[sha256sum] = "56fbb0c31d32cf4ff1a1b702732c3e8373e6d541c431329bcd931bd705991a35"

inherit catkin
