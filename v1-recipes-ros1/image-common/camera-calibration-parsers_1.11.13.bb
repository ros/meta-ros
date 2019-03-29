DESCRIPTION = "camera_calibration_parsers contains routines for reading and writing camera calibration parameters."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "boost rosconsole roscpp roscpp-serialization sensor-msgs yaml-cpp"

require image-common.inc

# OE upstream doesn't support python2 in Boost, but python3 only.
# So, drop python support from camera-calibration-parsers in case
# we're building a python2 flavour of ROS.
SRC_URI += "${@'file://0001-Drop-support-for-python.patch;striplevel=2' if d.getVar('PYTHON_PN', True) != 'python3' else ''}"
