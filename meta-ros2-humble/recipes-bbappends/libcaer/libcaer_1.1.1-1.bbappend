# Copyright (c) 2024 Wind River Systems, Inc.

inherit pkgconfig

# ERROR: libcaer-1.1.1-1-r0 do_package_qa: QA Issue: libcaer: /usr/lib/libcaer.so.3.3.15 contains probably-redundant RPATH /usr/lib [useless-rpaths]
DEPENDS:append:class-target = " chrpath-replacement-native"
do_install:append() {
    chrpath --delete ${D}${libdir}/*${SOLIBS}
}

FILES:${PN} += "${datadir}/caer/caer-base.cmake"

FILES:${PN}-dev += "${libdir}/libcaer.so"
