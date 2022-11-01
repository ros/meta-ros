LICENSE = "Fair & BSD-3-Clause & MIT"
LIC_FILES_CHKSUM = "file://FMILIB_License.txt;md5=b954fd969bf924475e3253a714f6c0ae \
                    file://LICENSE.md;md5=feb42903281464837bc0c9a861b1e7a1 \
                    file://ThirdParty/CMakeModules/UseDoxygen/COPYING-CMAKE-SCRIPTS;md5=54c7042be62e169199200bc6477f04d1 \
                    file://ThirdParty/c99_snprintf/c99-snprintf_1.1/COPYING;md5=e2ecb921277c8b452f57e512f11ab78a \
                    file://ThirdParty/Expat/expat-2.4.8/COPYING;md5=9e2ce3b3c4c0f2670883a23bbd7c37a9"

SRC_URI = "git://github.com/modelon-community/fmi-library.git;protocol=https;branch=master \
           file://0001-CMakeLists.txt-replacing-expat-with-system.patch \
           "

# Modify these as desired
PV = "2.4.1"
SRCREV = "5581e2fca21a18a19be05decc0a8b220dbcd709f"

S = "${WORKDIR}/git"

inherit cmake

DEPENDS = " \
    expat \
"

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = " \
    -DFMILIB_BUILD_STATIC_LIB=OFF \
    -DFMILIB_GENERATE_DOXYGEN_DOC=OFF \
    -DFMILIB_BUILD_TESTS=OFF \
    -DFMILIB_BUILD_BEFORE_TEST=OFF \
    -DFMILIB_INSTALL_PREFIX=${prefix} \
"

# fix qa [installed-vs-shipped]
# fix qa [dev-elf]
do_install:append() {
    rm -Rf ${D}/usr/doc
    mv ${D}${libdir}/libfmilib_shared.so ${D}${libdir}/libfmilib_shared.so.${PV}
    ln -s libfmilib_shared.so.${PV} ${D}${libdir}/libfmilib_shared.so
}