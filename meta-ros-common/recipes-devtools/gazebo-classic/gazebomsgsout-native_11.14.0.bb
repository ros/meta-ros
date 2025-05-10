LICENSE = "Apache-2.0 & GPL-2.0-only & LGPL-2.1-only & LGPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=2a461be67a1edf991251f85f3aadd1d0 \
                    file://LICENSE;md5=622f4fcdd9e66304dcb89897348be7b0 \
                    file://cmake/GPL-2;md5=b234ee4d69f5fce4486a80fdaf4a4263"

# A native built version of gazebomsgs_out is necessary to cross-compilegazebo11
SRC_URI = "git://github.com/gazebosim/gazebo-classic.git;protocol=https;branch=gazebo11 \
           file://gazebomsgs_out-CMakeLists.txt \
           file://gazebomsgs_out-gazebo-msgs-CMakeLists.txt"

# Modify these as desired
PV = "11.14.0"
SRCREV = "9b72949304e409d5f33150e87e6b348c54b5c015"

S = "${WORKDIR}/git"

OECMAKE_GENERATOR = "Unix Makefiles"

EXTRA_OECMAKE = " \
    -DINSTALL_GAZEBOMSGS_OUT_EXECUTABLE:BOOL=ON \
    -DPROTOBUF_PROTOC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/protoc \
    -DGZ_PROTOBUF_USE_CMAKE_CONFIG:BOOL=ON \
"

inherit cmake pkgconfig

DEPENDS = " \
    boost-native \
    ignition-math6-native \
    protobuf-native \
    protobuf-c-native \
    zlib-native \
"

do_configure:prepend() {
    cp ${UNPACKDIR}/gazebomsgs_out-CMakeLists.txt ${S}/CMakeLists.txt
    cp ${UNPACKDIR}/gazebomsgs_out-gazebo-msgs-CMakeLists.txt ${S}/gazebo/msgs/CMakeLists.txt
}

inherit native
