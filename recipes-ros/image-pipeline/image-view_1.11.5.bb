DESCRIPTION = "A simple viewer for ROS image topics."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "camera-calibration-parsers cv-bridge image-transport message-filters nodelet opencv rosconsole roscpp sensor-msgs std-srvs stereo-msgs"

require image-pipeline.inc

SRC_URI += "file://0001-image_view-must-explicitly-require-OpenCV-s-core-com.patch;striplevel=2"
