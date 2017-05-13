DESCRIPTION = "Contains nodelets for processing depth images such as those produced by OpenNI camera."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "boost cv-bridge eigen-conversions image-geometry image-transport message-filters nodelet sensor-msgs stereo-msgs tf2 tf2-ros"

require image-pipeline.inc

SRC_URI += "file://0001-find-Eigen3-with-ROS-cmake_modules-script.patch;striplevel=2"
