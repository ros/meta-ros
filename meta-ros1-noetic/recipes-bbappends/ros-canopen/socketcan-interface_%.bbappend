# Copyright (c) 2020 LG Electronics, Inc.

# linux-libc-headers package is empty, so not created, we cannot
# have runtime dependency on it
ROS_EXEC_DEPENDS_remove = "linux-libc-headers"

# Fails with webOS OSE which by default uses gold
FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-include-CMAKE_THREAD_LIBS_INIT-also-f.patch"
