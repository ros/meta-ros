# Copyright (c) 2020 LG Electronics, Inc.

inherit ros_insane_dev_so

do_install:append() {

    for i in ${D}${libdir}/${ROS_BPN}/cmake/* ${D}${ros_libdir}/${ROS_BPN}/cmake/*; do
        if [ -f "$i" ]; then
            echo "sed -i -e s:${STAGING_DIR_TARGET}:"":g $i"
            sed -i -e s:${STAGING_DIR_TARGET}:"":g $i
        fi
    done
}