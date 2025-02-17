LICENSE = "Apache-2.0 & GPL-2.0-only & LGPL-2.1-only & LGPL-3.0-only"

LIC_FILES_CHKSUM = "file://COPYING;md5=2a461be67a1edf991251f85f3aadd1d0 \
                    file://LICENSE;md5=622f4fcdd9e66304dcb89897348be7b0 \
                    file://cmake/GPL-2;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
                    file://deps/ann/include/ann/LGPL;md5=e6a600fd5e1d9cbde2d983680233ad02 \
                    file://deps/opende/GIMPACT/GIMPACT-LICENSE-BSD.TXT;md5=8b8d3fd534c235edacef40718034070c \
                    file://deps/opende/GIMPACT/GIMPACT-LICENSE-LGPL.TXT;md5=b6606274a9090b4293304cdf242059bb \
                    file://deps/opende/LICENSE-BSD.TXT;md5=c74e6304a772117e059458fb9763a928 \
                    file://gazebo/gui/qgv/LICENSE.txt;md5=4fbd65380cdd255951079008b364516c \
                    file://gazebo/rendering/skyx/License.txt;md5=ff710947873a98e70722effe719e2d48 \
                    file://media/gui/fonts/BITSTREAM-LICENSE;md5=11308e907cc211412cb9543184b1e623"

SRC_URI = "git://github.com/gazebosim/gazebo-classic.git;protocol=https;branch=gazebo11 \
           file://pkgconfig-use-ogre19.patch"

SRCREV = "b22c6e15e52299865b31093b8feebc9ca19e26e8"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

DEPENDS += " \
    bullet \
    doxygen-native \
    freeimage \
    gazebomsgsout-native \
    gdal \
    graphviz \
    gts \
    hdf5 \
    hdf5-native \
    ignition-common3 \
    ignition-fuel-tools4 \
    ignition-math6 \
    ignition-msgs5 \
    ignition-transport8 \
    libtar \
    libtinyxml2 \
    libusb1 \
    ogre19 \
    openal-soft \
    protobuf \
    protobuf-native \
    qwt-qt5 \
    sdformat9 \
    tbb \
"

# CMake Error: TRY_RUN() invoked in cross-compiling mode, please set the following cache variables appropriately:
#    FREEIMAGE_RUNS (advanced)
#    FREEIMAGE_RUNS__TRYRUN_OUTPUT (advanced)
EXTRA_OECMAKE = " \
    -DFREEIMAGE_RUNS=1 \
    -DFREEIMAGE_RUNS__TRYRUN_OUTPUT=0 \
    -DGAZEBOMSGS_OUT_EXECUTABLE=${STAGING_DIR_NATIVE}/usr/bin/gazebomsgs_out \
    -DGZ_PROTOBUF_USE_CMAKE_CONFIG:BOOL=ON \
    -DPROTOBUF_PROTOC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/protoc \
    -DUSE_HOST_CFLAGS=FALSE \
"

# CMake Error at src/gui/plugins/CMakeLists.txt:26 (QT5_WRAP_CPP):
#   Unknown CMake command "QT5_WRAP_CPP".
# Call Stack (most recent call first):
#   src/gui/plugins/modules/CMakeLists.txt:5 (gz_add_gui_library)
inherit ${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'pyqt5'], '', 'cmake_qt5', d)}


FILES:${PN} += " \
    ${datadir}/gazebo-11 \
    ${datadir}/gazebo \
    ${libdir}/gazebo-11 \
"

BBCLASSEXTEND = "nativesdk native"
