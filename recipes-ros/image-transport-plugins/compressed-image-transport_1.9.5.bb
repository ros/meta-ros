DESCRIPTION = "Compressed_image_transport provides a plugin to image_transport for transparently \
sending images encoded as JPEG or PNG."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "cv-bridge dynamic-reconfigure image-transport tf ${PYTHON_PN}-rospkg"

require image-transport-plugins.inc
