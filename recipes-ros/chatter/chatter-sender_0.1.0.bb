DESCRIPTION = "The chatter_sender package"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "chatter-msgs roscpp"

require chatter.inc

SRC_URI += "file://0001-rostest-is-optional.patch;striplevel=2"
