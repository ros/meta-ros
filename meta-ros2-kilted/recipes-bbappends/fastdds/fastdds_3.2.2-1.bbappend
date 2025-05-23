# Copyright (c) 2025 Wind River Systems, Inc.

# ERROR: fastdds-3.2.1-1-r0 do_package_qa: QA Issue: File /opt/ros/rolling/share/fastdds/cmake/fastdds-shared-targets.cmake in package fastdds-dev contains reference to TMPDIR [buildpaths]
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists-use-tinyxml2-by-name.patch \
            file://0001-FindTinyXML2.cmake-fix-find_library-libtinyxml2.patch"

# ERROR: fastdds-3.2.1-1-r0 do_package_qa: QA Issue: non -dev/-dbg/nativesdk- package fastdds contains symlink .so '/opt/ros/rolling/lib/libfastdds.so' [dev-so]
FILES:${PN}-dev += "${ros_libdir}/libfastdds.so"
