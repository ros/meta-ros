# Copyright (c) 2021 LG Electronics, Inc.
# Copyright (c) 2024 Wind River Systems, Inc.

LICENSE = "BSD-3-Clause"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0002-Fix-dependencies-262.patch\
            file://0005-Fix-compiler-warnings.patch\
            file://0006-Bump-minimum-cmake-version-265.patch\
            file://0007-Remove-octomap-dependency.patch\
"

inherit pkgconfig

ROS_BUILD_DEPENDS += "octomap"

ROS_BUILD_DEPENDS:remove = "liboctomap-dev"
ROS_EXPORT_DEPENDS:remove = "liboctomap-dev"
ROS_EXEC_DEPENDS:remove = "liboctomap-dev"

# ERROR: geometric-shapes-2.0.0-1-r0 do_package_qa: QA Issue:
# non -dev/-dbg/nativesdk- package contains symlink .so: geometric-shapes path '/work/raspberrypi4-webos-linux-gnueabi/geometric-shapes/2.0.0-1-r0/packages-split/geometric-shapes/usr/lib/libgeometric_shapes.so' [dev-so]
inherit ros_insane_dev_so
