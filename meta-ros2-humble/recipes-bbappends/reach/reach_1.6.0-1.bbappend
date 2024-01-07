# Copyright (c) 2023 Wind River Systems, Inc.

inherit python3native

ROS_BUILD_DEPENDS = " \
    ros-industrial-cmake-boilerplate-native \
"

# ERROR: reach-1.6.0-1-r0 do_package: QA Issue: reach: Files/directories were installed but not shipped in any package:
#   /usr/lib/python3/dist-packages/reach.so
#   /usr/share/ament_index
#   /usr/share/ament_index/resource_index
#   /usr/share/ament_index/resource_index/packages
#   /usr/share/ament_index/resource_index/packages/reach
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# reach: 5 installed and not shipped files. [installed-vs-shipped]
#
# ros_ament_cmake.bbclass does this automatically, but this recipe inherits just ros_cmake.bbclass
FILES:${PN}:prepend = " \
    ${datadir}/ament_index/resource_index/packages/reach \
"

do_install() {
    install -d -m 0755 ${D}/${libdir}
    install -D -m 0644 ${B}/libreach.so ${D}/${libdir}
    install -D -m 0644 ${B}/libreach_plugins.so ${D}/${libdir}

    install -d -m 0755 ${D}/${bindir}
    install -D -m 0755 ${B}/reach_app ${D}/${bindir}
    install -D -m 0755 ${B}/reach_data_loader ${D}/${bindir}

    install -d -m 0755 ${D}/${libdir}/cmake
    install -d -m 0755 ${D}/${libdir}/cmake/reach
    install -D -m 0755 ${B}/reach-config.cmake ${D}/${libdir}/cmake/reach
    install -D -m 0755 ${B}/reach-config-version.cmake ${D}/${libdir}/cmake/reach
    install -D -m 0755 ${B}/reach-targets.cmake ${D}/${libdir}/cmake/reach
}
