DESCRIPTION = "\
The nodelet package is designed to provide a way to run multiple \
algorithms in the same process with zero copy transport between \
algorithms. \
This package provides both the nodelet base class needed for \
implementing a nodelet, as well as the NodeletLoader class used \
for instantiating nodelets\
"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=16;endline=16;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "bondcpp boost message-generation pluginlib rosconsole roscpp rospy std-msgs libtinyxml"

require nodelet-core.inc
