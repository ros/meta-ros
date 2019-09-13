# Copyright (c) 2019 LG Electronics, Inc.

do_install_append() {
    # Duplicate of file under datadir/ROS_BPN/
    rm -f ${D}${datadir}/default_critics.xml
}
