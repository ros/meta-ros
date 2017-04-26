DESCRIPTION = "Contains a node that rotates an image stream in a way that minimizes the angle \
between a vector in some arbitrary frame and a vector in the camera frame."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=26;endline=26;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "cmake-modules cv-bridge dynamic-reconfigure eigen-conversions image-transport nodelet opencv roscpp tf2 tf2-geometry-msgs tf2-ros ${PYTHON_PN}-rospkg"

require image-pipeline.inc
