DESCRIPTION = "Interface for enforcing joint limits."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=6;endline=6;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "rostest roscpp hardware-interface urdfdom"

require ros-control.inc

SRC_URI += "file://0001-joint-limits-interface-CMakeLists-fix.patch;striplevel=2;name=patch"
SRC_URI[patch.md5sum] = "9001c9c5336587b00b15510445d63100"
SRC_URI[patch.sha256sum] = "e3708e8f5d974d8d386ea7c361fd568c297bba36c1e5f92ff49565f2fd529131"
