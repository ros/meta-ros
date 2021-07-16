# Copyright (c) 2020-2021 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-add-missing-resource_retriever-to-CAT.patch"

# ERROR: geometric-shapes-0.7.2-1-r0 do_package: QA Issue: geometric-shapes: Files/directories were installed but not shipped in any package:
#  /usr/opt/ros/noetic/lib/libgeometric_shapes.so.0.7.2
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# geometric-shapes: 1 installed and not shipped files. [installed-vs-shipped]
FILES:${PN} += "${ros_libdir}/lib*${SOLIBS}"

# ERROR: geometric-shapes-0.7.2-1-r0 do_package_qa: QA Issue:
# non -dev/-dbg/nativesdk- package contains symlink .so: geometric-shapes path '/work/qemux86-webos-linux/geometric-shapes/0.7.2-1-r0/packages-split/geometric-shapes/usr/opt/ros/noetic/lib/libgeometric_shapes.so' [dev-so]
inherit ros_insane_dev_so
