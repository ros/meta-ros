DESCRIPTION = "rosclean: cleanup filesystem resources (e.g. log files)"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

require ros.inc

ROS_PKG_SUBDIR = "tools"

SRC_URI += "file://0001-rosclean-Use-du-sk-1024-on-Linux-for-getting-disk-us.patch;striplevel=3"
