# Copyright (c) 2019 LG Electronics, Inc.

# Remove this empty directory.
do_install_append() {
    rmdir -p --ignore-fail-on-non-empty ${D}${datadir}/lib/${ROS_BPN}
}
