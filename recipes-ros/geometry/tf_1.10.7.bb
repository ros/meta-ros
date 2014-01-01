DESCRIPTION = "tf is a package that lets the user keep track of multiple coordinate frames over time."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=18;endline=18;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "angles geometry-msgs message-filters sensor-msgs tf2-ros"

require geometry.inc

SRC_URI += "file://0001-rostest-is-optional.patch;striplevel=2"
