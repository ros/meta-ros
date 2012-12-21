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

do_configure_prepend () {   
cat > /home/lukas/af_yocto/build/tmp/sysroots/x86_64-linux/usr/lib/python2.7/site-packages/easy-install.pth << EOF
import sys; sys.__plen = len(sys.path)
./setuptools-0.6c11-py2.7.egg
./rospkg-1.0.15-py2.7.egg
import sys; new=sys.path[sys.__plen:]; del sys.path[sys.__plen:]; p=getattr(sys,'__egginsert',0); sys.path[p:p]=new; sys.__egginsert = p+len(new)
EOF
}

do_rosinstall () {
	echo "Installing ros"
        mkdir -p ./ros-underlay
	rosinstall --catkin ./ros-underlay fuerte-ros-base.rosinstall
}
addtask rosinstall after do_patch before do_configure


