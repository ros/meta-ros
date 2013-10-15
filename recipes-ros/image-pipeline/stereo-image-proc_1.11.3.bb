DESCRIPTION = "Stereo and single image rectification and disparity processing."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "dynamic-reconfigure image-geometry image-proc image-transport message-filters nodelet opencv sensor-msgs stereo-msgs"

require image-pipeline.inc
