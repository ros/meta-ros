LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/sdformat.git;protocol=https;branch=main \
           file://remove-ignition-math-include-dirs.patch"

PV = "9.10.1"
SRCREV = "1774642ee6ac2d46f9fb335470dd7e881d0e6cc5"

S = "${WORKDIR}/git"

inherit cmake pkgconfig 
inherit ${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt5-layer', 'cmake_qt5', '', d)}

DEPENDS = " \
    ignition-cmake2 \
    ignition-math6 \
    ignition-tools1 \
    ignition-utils1 \
    libtinyxml2 \
    urdfdom \
    python3-psutil-native \
    ruby-native \
"

FILES:${PN} += " \
    ${libdir}/ruby/ignition/cmdsdformat9.rb \
    ${datadir}/ignition/sdformat9.yaml \
    ${datadir}/sdformat9/* \
    ${datadir}/gz/gz1.completion.d/sdf.bash_completion.sh \
"

# *.cmake files have hardcoded sysroot-s in them.
SSTATE_SCAN_FILES:append = " *.cmake"                                                                                                                                                                            

BBCLASSEXTEND = "nativesdk native"
