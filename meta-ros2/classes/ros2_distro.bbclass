# Copyright (c) 2019-2020 LG Electronics, Inc.

inherit ros_distro

# Place metadata unique to ROS 2 distros here.

# https://index.ros.org/doc/ros2/Installation/Linux-Development-Setup/#id3 says LANG must be in the environment. Allow it to be
# overridden in local.conf . (Can't place in conf/layer.conf as it causes do_patch() to fail when building linux-raspberrypi.)
export LANG ??= "en_US.UTF-8"

# *.cmake files have hardcoded sysroot-s in them.
SSTATE_SCAN_FILES_append = " *.cmake"

# The parent_prefix_path files are used on the target => remove the build tree from the paths. We assume this is only an issue
# with ROS 2.
do_install_append_class-target() {
    if [ -d ${D}${datadir}/ament_index/resource_index/parent_prefix_path ]; then
        find ${D}${datadir}/ament_index/resource_index/parent_prefix_path -type f \
            | xargs --no-run-if-empty sed -i -e 's@${STAGING_DIR_HOST}/@/@g' -e 's@${STAGING_DIR_NATIVE}/@/@g'
    else
        true
    fi
}
