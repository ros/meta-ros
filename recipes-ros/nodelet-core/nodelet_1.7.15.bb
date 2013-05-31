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
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/ros/nodelet_core/archive/${PV}.tar.gz;downloadfilename=${BP}.tar.gz"
SRC_URI[md5sum] = "840b98ace89034029569f20a2a41af05"
SRC_URI[sha256sum] = "4cc5a76ec90b0610b794128509923beba9b6dee2cb18fdeb6fd3ecc409051262"

DEPENDS = "bondcpp boost message-generation pluginlib rosconsole roscpp rospy std-msgs libtinyxml"

S = "${WORKDIR}/nodelet_core-${PV}/${PN}"

inherit catkin
