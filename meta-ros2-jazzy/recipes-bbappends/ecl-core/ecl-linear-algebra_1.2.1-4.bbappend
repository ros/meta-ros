# Copyright (c) 2023 Wind River Systems, Inc.

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package ecl-linear-algebra contains symlink .so '/usr/lib/libecl_linear_algebra.so' [dev-so]
FILES:${PN}-dev += " \
    ${libdir}/libecl_linear_algebra.so \
"

# sophus provides headers and does not have a runtime package
ROS_EXEC_DEPENDS:remove = "sophus"
