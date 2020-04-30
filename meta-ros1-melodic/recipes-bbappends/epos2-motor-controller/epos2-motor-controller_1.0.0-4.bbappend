# Copyright (c) 2020 LG Electronics, Inc.

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-use-pkg-config-to-find-libftdipp1.patch"

FILES_${PN} += "${datadir}/libepos2/package.xml"

# ERROR: epos2-motor-controller-1.0.0-4-r0 do_package_qa: QA Issue: non -dev/-dbg/nativesdk- package contains symlink .so: epos2-motor-controller path '/work/raspberrypi4-webos-linux-gnueabi/epos2-motor-controller/1.0.0-4-r0/packages-split/epos2-motor-controller/usr/lib/libepos2.so' [dev-so]
inherit ros_insane_dev_so
