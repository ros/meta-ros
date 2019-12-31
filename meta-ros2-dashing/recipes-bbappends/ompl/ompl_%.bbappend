# Copyright (c) 2019 LG Electronics, Inc.

inherit ros-insane

DEPENDS_append_class-target = " chrpath-replacement-native"
# For some reason ends with bad RPATH
# WARNING: ompl-1.4.2-2-r0 do_package_qa: QA Issue: ompl: /work/i586-oe-linux/ompl/1.4.2-2-r0/packages-split/ompl/usr/lib/libompl.so.1.4.2 contains probably-redundant RPATH /usr/lib [useless-rpaths]
do_install_append() {
    chrpath --delete ${D}${libdir}/*${SOLIBS}
}
