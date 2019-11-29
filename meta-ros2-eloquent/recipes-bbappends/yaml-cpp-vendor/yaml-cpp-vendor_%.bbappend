# Copyright (c) 2019 LG Electronics, Inc.

# This is the tree under which CMakeLists.txt installs the files. Assume it's been done for a good reason.
ROS_PREFIX = "${prefix}/opt/${ROS_BPN}"

do_install_append() {
    # Fix up prefix to be like what's in all the other .pc files of ROS components. Did not investigate why this one's value is
    # different. Write $<pcfiledir> to that isn't not accidentally expanded by bitbake.
    sed -i -e '/^prefix=/ s@=.*$@=$<pcfiledir>/../../..'${prefix}'@' -e 'y@<>@{}@' ${D}${ROS_PREFIX}/lib/pkgconfig/yaml-cpp.pc
}

SYSROOT_DIRS_append = " ${ROS_PREFIX}"

FILES_${PN}_prepend = "${ROS_PREFIX}/lib/libyaml-cpp.so* "

FILES_${PN}-dev_prepend = " \
    ${ROS_PREFIX}/include \
    ${ROS_PREFIX}/lib/cmake \
    ${ROS_PREFIX}/lib/pkgconfig \
"

INSANE_SKIP_${PN} = "dev-so libdir"

# HACK: Need to figure out how to have "opkg install" look in other directories for libraries to satisfy run-time dependencies.
# The link is removed in ros2_image_rm_vendor_lib_symlinks(), which is appended to ROOTFS_POSTINSTALL_COMMAND in
# ros2_image.bbclass .
pkg_postinst_${PN}() {
    mkdir -p $D${libdir}
    ln -s ../opt/${ROS_BPN}/lib/libyaml-cpp.so.0.6.2 $D${libdir}/libyaml-cpp.so.0.6
}
