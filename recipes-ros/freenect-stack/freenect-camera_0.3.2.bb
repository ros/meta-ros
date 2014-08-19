DESCRIPTION = "A libfreenect based ROS driver for the Microsoft Kinect. This is a port of the \
OpenNI driver to use libfreenect."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "camera-info-manager diagnostic-updater dynamic-reconfigure \
    image-transport libfreenect nodelet roscpp sensor-msgs pluginlib"

require freenect-stack.inc
