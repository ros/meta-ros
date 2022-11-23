# Copyright (c) 2021 LG Electronics, Inc.
# Copyright (c) 2022 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-Do-not-use-regex-on-CXXFLAGS.patch"

FILES:${PN}-dev += "${libdir}/libvisp*.so"
FILES:${PN} += "${datadir}/visp-3.5.0/"

# ERROR: visp-3.5.0-2-r0 do_package_qa: QA Issue: visp: /usr/lib/libvisp_ar.so.3.5.0 contains probably-redundant RPATH /usr/lib
DEPENDS:append:class-target = " chrpath-replacement-native"
do_install:append() {
    chrpath --delete ${D}${libdir}/*${SOLIBS}
}
