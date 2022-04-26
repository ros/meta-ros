# Copyright (c) 2019-2021 LG Electronics, Inc.

inherit ros_insane_dev_so

FILES:${PN} += "${prefix}/tools"

# rosidl-typesupport-fastrtps-cpp/1.0.2-1-r0/recipe-sysroot/usr/share/fastrtps/cmake/fast-discovery-server-targets.cmake:70
# expects the binary to exist:
# The imported target "fastdds::fast-discovery-server" references the file
# "TOPDIR/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/rosidl-typesupport-fastrtps-cpp/1.0.2-1-r0/recipe-sysroot/usr/bin/fast-discovery-server-1.0.0"
# OE doesn't stage ${bindir} for target recipes, but in this case the fastdds::fast-discovery-server isn't
# being called during the cross-build, so we can include it just to keep CMake happy
sysroot_stage_all:append() {
    sysroot_stage_dir ${D}${bindir} ${SYSROOT_DESTDIR}${bindir}
}
