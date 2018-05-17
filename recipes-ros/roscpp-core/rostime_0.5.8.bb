DESCRIPTION = "Time and Duration implementations for C++ libraries, including roscpp."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "boost cpp-common"

require roscpp-core.inc

SRC_URI += "file://0001-argument-to-boost-microseconds-must-be-integral.patch;striplevel=2"
