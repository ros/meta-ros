# remove /usr/tool directory from install to fix install-vs-shipped QA
do_install:append() {
    rm -Rf ${D}/usr/tools
}

# fix dev-so qa
FILES:${PN}-dev += " \
    ${libdir}/*.so \
"

FILES:${PN}:append = " \
    /usr/share/fastRTPS_profiles.xsd \
    /usr/share/fastdds_static_discovery.xsd \
"
# Setting the results from a test program on the target
EXTRA_OECMAKE:append = " \
    -DSM_RUN_RESULT="PTHREAD_RWLOCK_PREFER_READER_NP" \
    -DSM_RUN_RESULT__TRYRUN_OUTPUT="PTHREAD_RWLOCK_PREFER_READER_NP" \
"

# fixes for host injection through tinyxml2
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI:append = " \
    file://0001-CMakeLists.txt-fixing-host-injection.patch \
"


# Copyright (c) 2019-2021 LG Electronics, Inc.
# rosidl-typesupport-fastrtps-cpp/1.0.2-1-r0/recipe-sysroot/usr/share/fastrtps/cmake/fast-discovery-server-targets.cmake:70
# expects the binary to exist:
# The imported target "fastdds::fast-discovery-server" references the file
# "TOPDIR/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/rosidl-typesupport-fastrtps-cpp/1.0.2-1-r0/recipe-sysroot/usr/bin/fast-discovery-server-1.0.0"
# OE doesn't stage ${bindir} for target recipes, but in this case the fastdds::fast-discovery-server isn't
# being called during the cross-build, so we can include it just to keep CMake happy
sysroot_stage_all:append() {
    sysroot_stage_dir ${D}${bindir} ${SYSROOT_DESTDIR}${bindir}
}
