DESCRIPTION = "This package provides a recovery behavior for the navigation stack that attempts to \
clear space by reverting the costmaps used by the navigation stack to the static map outside of a \
given area."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=01c2bc31767ccb3a68e12f02612b2a97"

DEPENDS = "cmake-modules costmap-2d libeigen nav-core pluginlib roscpp tf"

require navigation.inc
