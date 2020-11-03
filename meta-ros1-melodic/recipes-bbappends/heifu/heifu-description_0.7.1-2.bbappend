# Copyright (c) 2020 LG Electronics, Inc.

do_install_append() {
    if [ "${TARGET_ARCH}" != "x86_64" ] ; then
        bbnote "Removing prebuilt plugins, because they are provided only for x86_64 architecture"
        rm -fv ${D}/${ros_datadir}/${ROS_BPN}/plugins/lib*.so
    fi
}
