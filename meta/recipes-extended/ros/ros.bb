DESCRIPTION  = "ROS"
HOMEPAGE = "http://ros.org"

LICENSE = "CLOSED"
# LIC_FILES_CHKSUM = "file://LICENSE.BSD;md5=62272bd11c97396d4aaf1c41bc11f7d8"

DEPENDS = "python-empy-native python-rospkg-native python-native python-pyyaml-native python-nose-native"

PR = "r0"

SRC_URI = "file://ros_server.tar.gz \
	file://fuerte-ros-base.rosinstall"

S = "${WORKDIR}"

EXTRA_OECMAKE = "-DSETUPTOOLS_DEB_LAYOUT=OFF"


do_configure_prepend () {   
cat > /home/lukas/af_yocto/build/tmp/sysroots/x86_64-linux/usr/lib/python2.7/site-packages/easy-install.pth << EOF
import sys; sys.__plen = len(sys.path)
./setuptools-0.6c11-py2.7.egg
./rospkg-1.0.15-py2.7.egg
import sys; new=sys.path[sys.__plen:]; del sys.path[sys.__plen:]; p=getattr(sys,'__egginsert',0); sys.path[p:p]=new; sys.__egginsert = p+len(new)
EOF
}

DEPENDS += " cmake-native "

# We need to unset CCACHE otherwise cmake gets too confused
CCACHE = ""

# We want the staging and installing functions from autotools
inherit autotools

# Use in-tree builds by default but allow this to be changed
# since some packages do not support them (e.g. llvm 2.5).
OECMAKE_SOURCEPATH ?= "."

# If declaring this, make sure you also set EXTRA_OEMAKE to
# "-C ${OECMAKE_BUILDPATH}". So it will run the right makefiles.
OECMAKE_BUILDPATH ?= ""

# C/C++ Compiler (without cpu arch/tune arguments)
OECMAKE_C_COMPILER ?= "`echo ${CC} | sed 's/^\([^ ]*\).*/\1/'`"
OECMAKE_CXX_COMPILER ?= "`echo ${CXX} | sed 's/^\([^ ]*\).*/\1/'`"

# Compiler flags
OECMAKE_C_FLAGS ?= "${HOST_CC_ARCH} ${TOOLCHAIN_OPTIONS} ${CPPFLAGS}"
OECMAKE_CXX_FLAGS ?= "${HOST_CC_ARCH} ${TOOLCHAIN_OPTIONS} ${CXXFLAGS} -fpermissive"
OECMAKE_C_FLAGS_RELEASE ?= "${SELECTED_OPTIMIZATION} ${CPPFLAGS} -DNDEBUG"
OECMAKE_CXX_FLAGS_RELEASE ?= "${SELECTED_OPTIMIZATION} ${CXXFLAGS} -DNDEBUG"
OECMAKE_C_LINK_FLAGS ?= "${HOST_CC_ARCH} ${TOOLCHAIN_OPTIONS} ${CPPFLAGS} ${LDFLAGS}"
OECMAKE_CXX_LINK_FLAGS ?= "${HOST_CC_ARCH} ${TOOLCHAIN_OPTIONS} ${CXXFLAGS} ${LDFLAGS}"

OECMAKE_RPATH ?= ""
OECMAKE_PERLNATIVE_DIR ??= ""
OECMAKE_EXTRA_ROOT_PATH ?= ""


do_install () {
	echo "Installing ros"
        mkdir -p ./ros-underlay
	rosinstall --catkin ./ros-underlay fuerte-ros-base.rosinstall
	cd ./ros-underlay
	mkdir -p build
	cd ./build
	cmake .. -DCMAKE_INSTALL_PREFIX=/opt/ros/fuerte -DSETUPTOOLS_DEB_LAYOUT=OFF
}

inherit pythonnative


