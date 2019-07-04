DESCRIPTION = "A simple viewer for ROS image topics."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "camera-calibration-parsers cv-bridge dynamic-reconfigure image-transport message-filters nodelet opencv rosconsole roscpp sensor-msgs std-srvs stereo-msgs gtk+"

require image-pipeline.inc

inherit distro_features_check
ANY_OF_DISTRO_FEATURES = "${GTK2DISTROFEATURES}"

SRC_URI += "file://image-view-remove-unused-signals-boost-component.patch;patchdir=.."
