DESCRIPTION = "Contains nodelets for processing depth images such as those produced by OpenNI camera."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "boost cv-bridge libeigen image-geometry image-transport message-filters nodelet pcl-conversions pcl-ros sensor-msgs stereo-msgs tf"

require image-pipeline.inc
