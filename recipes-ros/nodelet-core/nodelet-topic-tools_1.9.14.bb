DESCRIPTION = "This package contains common nodelet tools such as a mux, demux and throttle."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "dynamic-reconfigure ${PYTHON_PN}-rospkg"

require nodelet-core.inc
