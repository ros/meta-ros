DESCRIPTION = "This package provides a C++ interface for camera calibration information."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=15;endline=15;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "boost camera-calibration-parsers image-transport roscpp roslib sensor-msgs"

require image-common.inc

do_configure_append(){
  sed -i -e 's:-L\/opt\/ros\/${ROSDISTRO}\/lib::g' ${B}/CMakeFiles/camera_info_manager.dir/link.txt
  sed -i -e 's:\/opt\/ros\/${ROSDISTRO}\/lib\/libcamera_calibration_parsers.so::g' ${B}/CMakeFiles/camera_info_manager.dir/link.txt
  sed -i -e 's:\/opt\/ros\/${ROSDISTRO}\/lib\/libimage_transport.so::g' ${B}/CMakeFiles/camera_info_manager.dir/link.txt
}
