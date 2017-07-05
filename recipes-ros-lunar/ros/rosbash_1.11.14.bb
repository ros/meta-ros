DESCRIPTION = "Assorted shell commands for using ros with bash."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

require ros.inc

ROS_PKG_SUBDIR = "tools"

RDEPENDS_${PN} = "bash findutils"
