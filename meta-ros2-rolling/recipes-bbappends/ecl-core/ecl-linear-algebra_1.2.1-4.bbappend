# Copyright (c) 2023 Wind River Systems, Inc.

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package ecl-linear-algebra contains symlink .so '/usr/lib/libecl_linear_algebra.so' [dev-so]
inherit ros_insane_dev_so

# sophus provides headers and does not have a runtime package
ROS_EXEC_DEPENDS:remove = "sophus"
