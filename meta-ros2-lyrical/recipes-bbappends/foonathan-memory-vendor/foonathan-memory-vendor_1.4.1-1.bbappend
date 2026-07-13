# Copyright (c) 2019 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

# Since 1.4.1 the vendor checks for a system foonathan_memory by spawning a
# child cmake via `cmake --find-package`, which does not inherit the cross
# toolchain/sysroot. The staged library is never found and the vendor falls
# back to cloning at build time, which the network-isolated do_compile blocks.
SRC_URI += "file://0001-Use-in-process-find_package-for-system-foonathan_me.patch"

ROS_BUILD_DEPENDS += "\
    foonathan-memory \
"
