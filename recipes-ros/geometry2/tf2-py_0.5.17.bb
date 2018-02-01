DESCRIPTION = "The tf2_py package"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "rospy tf2"

EXTRA_OECMAKE += "-DCMAKE_SKIP_RPATH=ON"

require geometry2.inc
