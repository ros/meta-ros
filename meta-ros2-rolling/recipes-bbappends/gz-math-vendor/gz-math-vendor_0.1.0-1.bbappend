# Copyright (c) 2024 Wind River Systems, Inc.

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package gz-math-vendor contains symlink .so '/opt/ros/rolling/lib/libgz-math7.so' [dev-so]
inherit ros_insane_dev_so

DEPENDS += "gz-math7"

SYSROOT_DIRS += "${ros_prefix}/opt/gz_math_vendor/extra_cmake/lib/cmake/gz-math"

BBCLASSEXTEND = "native nativesdk"
