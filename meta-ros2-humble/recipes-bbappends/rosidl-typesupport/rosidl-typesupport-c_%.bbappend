# Copyright (c) 2019-2020 LG Electronics, Inc.
# Copyright (c) 2022 Acceleration Robotics, S.L.

ROS_BUILD_DEPENDS:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'connext', 'rosidl-typesupport-connext-c', '', d)}"
ROS_BUILD_DEPENDS:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'opensplice', 'rosidl-typesupport-opensplice-c', '', d)}"

# Deal with CMake Error while building recipe
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://0001-Deal-with-downstream-recipe-build-errors.patch \
"

# ERROR: do_package: Files/directories were installed but not shipped in any package
#
# NOTE: Can't use ${PN} in the additions below because of the "-" and "_" conflict (recipes and package names differ in this regard)
#
do_install:append:class-target() {
    mkdir -p ${D}/usr/lib/python3.9/site-packages/
    mv ${D}${STAGING_DIR_NATIVE}/usr/lib/python3.9/site-packages/${ROS_BPN}* ${D}/usr/lib/python3.9/site-packages/
    rm -r ${D}/home
}

# rosidl-typesupport-c: Files/directories were installed but not shipped in any package:
#   /usr/lib/librosidl_typesupport_c.so
FILES:${PN} += "${libdir}/lib*${SOLIBSDEV}"