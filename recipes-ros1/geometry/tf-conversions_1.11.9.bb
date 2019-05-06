DESCRIPTION = "This package contains a set of conversion functions to convert common tf datatypes (point, vector, pose, etc) into semantically identical datatypes used by other libraries."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=19;endline=19;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "libeigen geometry-msgs kdl-conversions tf cmake-modules"

require geometry.inc
