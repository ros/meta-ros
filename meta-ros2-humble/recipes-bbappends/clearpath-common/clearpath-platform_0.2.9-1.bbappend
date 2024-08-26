# Copyright (c) 2024 Wind River Systems, Inc.

# ERROR: QA Issue: /usr/lib/clearpath_platform/lighting_node contained in \
# package clearpath-platform requires liblighting_lib.so()(64bit), but no \
# providers found in RDEPENDS:clearpath-platform? [file-rdeps]
do_install:append() {
    install -d ${D}${libdir}
    install -D -m 0644 ${B}/liblighting_lib.so ${D}/${libdir}
}
