DESCRIPTION = "Theora_image_transport provides a plugin to image_transport for \
transparently sending an image stream encoded with the Theora codec."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "cv-bridge dynamic-reconfigure image-transport tf rosbag ${PYTHON_PN}-rospkg"

require image-transport-plugins.inc
