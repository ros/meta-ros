# Copyright (c) 2019 LG Electronics, Inc.

inherit ros_image

# Place metadata unique to ROS 2 images here.

#
# Remove each symlink added by pkg_postinst() functions in *-vendor recipes (which only exist in ROS 2). NB. Bitbake gets confused
# if _remove is used instead of _rm.
#

ROOTFS_POSTINSTALL_COMMAND += "ros2_image_rm_vendor_lib_symlinks; "

ros2_image_rm_vendor_lib_symlinks() {
    if [ -d ${IMAGE_ROOTFS}${prefix}/opt/yaml_cpp_vendor ]; then
        rm -f ${IMAGE_ROOTFS}${libdir}/libyaml-cpp${SOLIBS}
    else
        true
    fi
}
