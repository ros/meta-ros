DESCRIPTION = "Parse a multiple poses from yaml and provide as topic and service."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "roscpp visualization-msgs yocs-msgs geometry-msgs yaml-cpp"

require yujin-ocs.inc

SRC_URI += "file://0001-yocs_waypoint_provider-also-install-libraries.patch;striplevel=2"
