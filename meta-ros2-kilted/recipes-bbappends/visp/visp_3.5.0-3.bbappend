# Copyright (c) 2022 Wind River Systems, Inc.

# x86_64-oe-linux-g++: warning: 2: linker input file unused because linking not done
# x86_64-oe-linux-g++: error: 2: linker input file not found: No such file or directory
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-Do-not-use-regex-on-CXXFLAGS.patch"

# ERROR: visp-3.5.0-2-r0 do_package: QA Issue: visp: Files/directories were installed but not shipped in any package:
#   /usr/share/visp-3.5.0
#   /usr/share/visp-3.5.0/data
#   ...
#   Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# visp: 64 installed and not shipped files. [installed-vs-shipped]
FILES:${PN} += "${datadir}/visp-3.5.0/"

# ERROR: visp-3.5.0-2-r0 do_package_qa: QA Issue: non -dev/-dbg/nativesdk- package visp contains symlink .so '/usr/lib/libvisp_imgproc.so'
FILES:${PN}-dev += "${libdir}/libvisp*.so"

# ERROR: visp-3.5.0-2-r0 do_package_qa: QA Issue: visp: /usr/lib/libvisp_ar.so.3.5.0 contains probably-redundant RPATH /usr/lib
DEPENDS:append:class-target = " chrpath-replacement-native"
do_install:append() {
    chrpath --delete ${D}${libdir}/*${SOLIBS}
}
