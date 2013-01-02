DESCRIPTION  = "ROS"
HOMEPAGE = "http://ros.org"

LICENSE = "CLOSED"
# LIC_FILES_CHKSUM = "file://LICENSE.BSD;md5=62272bd11c97396d4aaf1c41bc11f7d8"

DEPENDS = "python-empy-native python-rospkg-native python-native python-pyyaml-native python-nose-native eglibc"

PR = "r0"

SRC_URI = "file://fuerte-ros-base.rosinstall"

S = "${WORKDIR}"

OECMAKE_SOURCEPATH = "${WORKDIR}/ros-underlay"
EXTRA_OECMAKE = "-DSETUPTOOLS_DEB_LAYOUT=OFF"

inherit pythonnative cmake

do_rosinstall () {
	echo "Installing ros"
        mkdir -p ./ros-underlay
	rosinstall --catkin ./ros-underlay fuerte-ros-base.rosinstall
}
addtask rosinstall after do_patch before do_configure


