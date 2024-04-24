# Copyright (c) 2019-2021 LG Electronics, Inc.
# Copyright (c) 2023 Wind River Systems, Inc.

inherit ros_insane_dev_so

FILES:${PN} += "${prefix}/tools"
# ERROR: fastrtps-2.10.2-1-r0 do_package: QA Issue: fastrtps: Files/directories were installed but not shipped in any package:
FILES:${PN} += "${datadir}/fastRTPS_profiles.xsd ${datadir}/fastdds_static_discovery.xsd"

# CMake Error: TRY_RUN() invoked in cross-compiling mode, please set the
# following cache variables appropriately:
#    SM_RUN_RESULT (advanced)
#    SM_RUN_RESULT__TRYRUN_OUTPUT (advanced)
EXTRA_OECMAKE += " -DSM_RUN_RESULT=0 -DSM_RUN_RESULT__TRYRUN_OUTPUT=PTHREAD_RWLOCK_PREFER_WRITER_NONRECURSIVE_NP "

# rosidl-typesupport-fastrtps-cpp/1.0.2-1-r0/recipe-sysroot/usr/share/fastrtps/cmake/fast-discovery-server-targets.cmake:70
# expects the binary to exist:
# The imported target "fastdds::fast-discovery-server" references the file
# "TOPDIR/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/rosidl-typesupport-fastrtps-cpp/1.0.2-1-r0/recipe-sysroot/usr/bin/fast-discovery-server-1.0.0"
# OE doesn't stage ${bindir} for target recipes, but in this case the fastdds::fast-discovery-server isn't
# being called during the cross-build, so we can include it just to keep CMake happy
sysroot_stage_all:append() {
    sysroot_stage_dir ${D}${bindir} ${SYSROOT_DESTDIR}${bindir}
}
