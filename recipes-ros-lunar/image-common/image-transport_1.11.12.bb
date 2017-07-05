DESCRIPTION = "image_transport should always be used to subscribe to and publish images."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "message-filters pluginlib rosconsole roscpp roslib sensor-msgs class-loader"

require image-common.inc
