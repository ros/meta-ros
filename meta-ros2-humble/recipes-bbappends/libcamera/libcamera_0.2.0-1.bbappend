# Copyright (c) 2021 LG Electronics, Inc.
# Copyright (c) 2023 Wind River Systems, Inc.

# ERROR: Nothing RPROVIDES 'gcc-runtime' (but libcamera_0.1.0-1.bb RDEPENDS on or otherwise requires it)
# libatomic is just one of the packages provided by gcc-runtime recipe
# but gcc-runtime recipe doesn't have libatomic in PROVIDES, so we cannot map
# libatomic in rosdep to libatomic (without adding libatomic to PROVIDES in gcc-runtime
# bbappend). And we cannot leave gcc-runtime in ROS_EXEC_DEPENDS, because
# gcc-runtime recipe doesn't have PN in PACKAGES (and we would still depend
# on do_package shlibs handling to add runtime dependency on actual package
# with libatomic library)
ROS_EXEC_DEPENDS:remove = "gcc-runtime"
# there is no native support for gcc-runtime, so also no libatomic, add it only for target builds
ROS_EXEC_DEPENDS:append-class-target = " libatomic"
# and also remove it from build time depends when buiding native rc-utils
DEPENDS:remove:class-native = "gcc-runtime-native gcc-runtime"

# ERROR: Task (libcamera_0.1.0-1.bb:do_configure) failed with exit code '1'
# ../git/meson.build:258:7: ERROR: python3 is missing modules: jinja2, ply, jinja2, yaml
ROS_BUILDTOOL_DEPENDS += " \
    python3-jinja2-native \
    python3-ply-native \
    python3-pyyaml-native \
"

# ERROR: libcamera-0.1.0-1-r0 do_package_qa: QA Issue:
# non -dev/-dbg/nativesdk- package libcamera contains symlink .so '/usr/lib/libcamera.so'
# non -dev/-dbg/nativesdk- package libcamera contains symlink .so '/usr/lib/libcamera-base.so' [dev-so]
FILES:${PN}-dev += " ${libdir}/libcamera.so"
FILES:${PN}-dev += " ${libdir}/libcamera-base.so"
