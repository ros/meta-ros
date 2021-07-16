# Copyright (c) 2019 LG Electronics, Inc.

do_install:append:class-target() {
    # This testing script requires bash, which isn't always on the target.
    rm -f ${D}${ros_libdir}/${ROS_BPN}/test_wrapper
}
