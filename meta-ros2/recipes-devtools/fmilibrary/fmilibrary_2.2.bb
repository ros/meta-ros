# Copyright (c) 2019-2020 LG Electronics, Inc.

DESCRIPTION = "Extensible Modelica-based platform for optimization, simulation and analysis of complex dynamic systems."
HOMEPAGE = "https://jmodelica.org/"
SECTION = "devel"
LICENSE = "Zlib"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=feb42903281464837bc0c9a861b1e7a1"

DEPENDS = "expat"

# matches with tag 2.2
SRCREV = "0edf0b0387c4b0027b758956e8f1321d89c2fb75"
SRC_URI = "git://github.com/modelon-community/fmi-library \
    file://0001-fmixml-use-system-expat-instead-of-building-own-with.patch \
"

S = "${WORKDIR}/git"

inherit cmake

# cannot run runtime tests on host while cross-compiling
# /bin/sh: 1: /jenkins/mjansa/build-ros-thud-mcf-herb/artifacts/BUILD-webos-eloquent-thud.mcf/work/raspberrypi3-webos-linux-gnueabi/fmilibrary-vendor/0.1.1-1-r0/build/FMILibraryProject-prefix/src/FMILibraryProject-build/compress_test_fmu_zip: Exec format error
EXTRA_OECMAKE += "-DFMILIB_BUILD_TESTS=OFF"

# Don't want the doxygen-native dependency
EXTRA_OECMAKE += "-DFMILIB_GENERATE_DOXYGEN_DOC=OFF"

# The default is in WORKDIR ${FMILibrary_BINARY_DIR}/../install
EXTRA_OECMAKE += "-DFMILIB_INSTALL_PREFIX=${prefix}"

# We don't want static expat to be included
EXTRA_OECMAKE += "-DFMILIB_BUILD_STATIC_LIB=OFF"

do_install_append() {
    install -d ${D}${datadir}/${PN}/doc
    mv ${D}${prefix}/doc ${D}${datadir}/${PN}/doc
}

# ERROR: fmilibrary-2.0.3-r0 do_package_qa: QA Issue: -dev package contains non-symlink .so: fmilibrary-dev path '/work/raspberrypi3-webos-linux-gnueabi/fmilibrary/2.0.3-r0/packages-split/fmilibrary-dev/usr/lib/libfmilib_shared.so' [dev-elf]
FILES_SOLIBSDEV = ""
FILES_${PN} += " \
    ${libdir}/lib*${SOLIBSDEV} \
"
