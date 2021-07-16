# Copyright (c) 2019-2020 LG Electronics, Inc.

inherit ros_insane_dev_so

DEPENDS:append:class-target = " chrpath-replacement-native"
# For some reason ends with bad RPATH
# WARNING: ompl-1.4.2-2-r0 do_package_qa: QA Issue: ompl: /work/i586-oe-linux/ompl/1.4.2-2-r0/packages-split/ompl/usr/lib/libompl.so.1.4.2 contains probably-redundant RPATH /usr/lib [useless-rpaths]
do_install:append() {
    chrpath --delete ${D}${libdir}/*${SOLIBS}
}

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://0001-compilation-fix-for-boost-1.71.patch \
"
