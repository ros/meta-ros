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

SRC_URI[md5sum] = "be206acca97aa658b31266ddf9d768b9"
SRC_URI[sha256sum] = "76419dd7afdac31d4813e5e0665af61eb9bccc2c450a8b64886c06030f6d5a1c"

DEPENDS = "bondcpp boost message-generation pluginlib rosconsole roscpp rospy std-msgs libtinyxml"

S = "${WORKDIR}/nodelet_core-${PV}/${PN}"

inherit catkin
