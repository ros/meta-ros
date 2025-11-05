# Copyright (c) 2024 Wind River Systems, Inc.

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package gz-utils-vendor contains symlink .so '/opt/ros/rolling/lib/libgz-utils2.so' [dev-so]
inherit ros_insane_dev_so

ROS_BUILD_DEPENDS += "gz-utils3"

# Not required in vendor package
ROS_BUILD_DEPENDS:remove = "cli11"
ROS_EXEC_DEPENDS:remove = "cli11"

BBCLASSEXTEND = "native nativesdk"
