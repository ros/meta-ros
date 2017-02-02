DESCRIPTION = "CvBridge converts between ROS Image messages and OpenCV images"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "boost opencv rosconsole sensor-msgs python-numpy-native"

require vision-opencv.inc

SRC_URI += "file://0001-address-gcc6-build-error-in-cv_bridge-and-tune.patch;striplevel=2"
