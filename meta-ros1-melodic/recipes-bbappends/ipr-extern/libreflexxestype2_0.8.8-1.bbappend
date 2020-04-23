# Copyright (c) 2020 LG Electronics, Inc.

# Uses dpkg on build system to check the target architecture :/.
# Restrict this recipe with COMPATIBLE_MACHINE and then just force
# SUPPORTED to true to ignore this non-sense

# find_program(CMAKE_DPKG dpkg /bin /usr/bin /usr/local/bin)
# if(CMAKE_DPKG)
#   exec_program(dpkg ARGS --print-architecture OUTPUT_VARIABLE CMAKE_DPKG_ARCH)
#   if(CMAKE_DPKG_ARCH MATCHES "amd64")
#     message(STATUS "+++++++++++++++++ DETECTED 64 bit +++++++++++++++++")
#     set(SUPPORTED "true")
# #   elseif(CMAKE_DPKG_ARCH MATCHES "i386")
# #     message(STATUS "+++++++++++++++++ DETECTED 32 bit +++++++++++++++++")
# #     set(SUPPORTED "true")

COMPATIBLE_MACHINE = "(^$)"
COMPATIBLE_MACHINE_x86-64 = "(.*)"
EXTRA_OECMAKE += "-DSUPPORTED=true"

# ERROR: libreflexxestype2-0.8.8-1-r0 do_package_qa: QA Issue: non -dev/-dbg/nativesdk- package contains symlink .so: libreflexxestype2 path '/work/core2-64-oe-linux/libreflexxestype2/0.8.8-1-r0/packages-split/libreflexxestype2/opt/ros/melodic/lib/libreflexxestypeII.so' [dev-so]
inherit ros_insane_dev_so
