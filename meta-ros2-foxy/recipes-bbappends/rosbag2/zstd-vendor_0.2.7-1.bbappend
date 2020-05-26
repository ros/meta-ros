# Copyright (c) 2020 LG Electronics, Inc.

# ERROR: zstd-vendor-0.2.7-1-r0 do_package_qa: QA Issue: non -dev/-dbg/nativesdk- package contains symlink .so: zstd-vendor path '/work/core2-64-oe-linux/zstd-vendor/0.2.7-1-r0/packages-split/zstd-vendor/usr/lib/libzstd.so' [dev-so]
inherit ros_insane_dev_so

do_install_append() {
    sed -i "s@^prefix=${B}/zstd_vendor_install@prefix=/usr@g" ${D}${libdir}/pkgconfig/libzstd.pc
}
