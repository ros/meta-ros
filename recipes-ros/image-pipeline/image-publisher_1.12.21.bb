DESCRIPTION = "Node publishing an image stream from single image file or avi motion file."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "camera-info-manager cv-bridge dynamic-reconfigure image-transport nodelet roscpp sensor-msgs ${PYTHON_PN}-rospkg"

require image-pipeline.inc
