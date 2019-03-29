DESCRIPTION = "This package contains the ROS bindings for the tf2 library, for both Python and C++."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "actionlib message-filters rosgraph tf2 tf2-py"

RDEPENDS_${PN} = "actionlib message-filters rosgraph tf2 tf2-py"

require geometry2.inc
