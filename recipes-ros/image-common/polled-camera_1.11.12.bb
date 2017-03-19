DESCRIPTION = "polled_camera contains a service and C++ helper classes for implementing a polled \
camera driver node and requesting images from it."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "message-generation image-transport rosconsole roscpp sensor-msgs std-msgs"

require image-common.inc
