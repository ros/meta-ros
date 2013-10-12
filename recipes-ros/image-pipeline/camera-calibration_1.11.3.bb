DESCRIPTION = "camera_calibration allows easy calibration of monocular or stereo \
  cameras using a checkerboard calibration target."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=22;endline=22;md5=d566ef916e9dedc494f5f793a6690ba5"

require image-pipeline.inc

SRC_URI += "file://0001-check-for-CATKIN_ENABLE_TESTING.patch;striplevel=2"
