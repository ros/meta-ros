# Copyright (c) 2021 LG Electronics, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    generate-parameter-library-py-native \
"

# ERROR: moveit-servo-2.1.0-1-r0 do_package_qa: QA Issue:
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-servo path '/work/raspberrypi4-webos-linux-gnueabi/moveit-servo/2.1.0-1-r0/packages-split/moveit-servo/usr/lib/libmoveit_servo.so' [dev-so]
inherit ros_insane_dev_so
