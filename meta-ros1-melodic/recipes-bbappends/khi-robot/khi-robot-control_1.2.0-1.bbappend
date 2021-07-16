# Copyright (c) 2021 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-allow-to-set-KRNX_ARCHITECTURE-direct.patch \
    file://0002-khi_robot_krnx_driver.cpp-add-missing-return.patch \
"

# Uses CMAKE_LIBRARY_ARCHITECTURE check the target architecture:
# message(STATUS "CMAKE_LIBRARY_ARCHITECTURE : ${CMAKE_LIBRARY_ARCHITECTURE}")
# if( ${CMAKE_LIBRARY_ARCHITECTURE} MATCHES ".*x86_64.*" )
#   set(krnx_lib_name krnx-x86_64)
# elseif( ${CMAKE_LIBRARY_ARCHITECTURE} MATCHES ".*aarch64.*" )
#   set(krnx_lib_name krnx-aarch64)
# elseif( ${CMAKE_LIBRARY_ARCHITECTURE} MATCHES ".*i386.*" )
#   set(krnx_lib_name krnx-i386)
# elseif( ${CMAKE_LIBRARY_ARCHITECTURE} MATCHES ".*arm.*gnueabihf" )
#   set(krnx_lib_name krnx-armhf)
# elseif( ${CMAKE_LIBRARY_ARCHITECTURE} MATCHES ".*arm.*gnueabi" )
#   set(krnx_lib_name krnx-armel)
# else()
#   message(WARNING "\nCould not detect system processor architecture: assuming 'x86_64'. This may result in non-working binaries.")
#   set(krnx_lib_name krnx-x86_64)
# endif()
# and fails because in our builds CMAKE_LIBRARY_ARCHITECTURE is ampty, so it always assumes x86_64.
# and then fails with: | -- Found KRNX library at: krnx_LIBRARIES-NOTFOUND

# Restrict this recipe with COMPATIBLE_MACHINE and then just force
# ARCHITECTURE with EXTRA_OECMAKE

COMPATIBLE_MACHINE = "(^$)"
COMPATIBLE_MACHINE:x86-64 = "(.*)"
COMPATIBLE_MACHINE:x86 = "(.*)"
COMPATIBLE_MACHINE:aarch64 = "(.*)"
COMPATIBLE_MACHINE:armv7a = "(.*)"
COMPATIBLE_MACHINE:armv7ve = "(.*)"

KRNX_ARCHITECTURE:x86-64 = "x86_64"
KRNX_ARCHITECTURE:x86 = "i386"
KRNX_ARCHITECTURE:aarch64 = "aarch64"
KRNX_ARCHITECTURE:armv7a = "${@bb.utils.contains('TUNE_FEATURES', 'callconvention-hard', 'armhf', 'armel', d)}"
KRNX_ARCHITECTURE:armv7ve = "${@bb.utils.contains('TUNE_FEATURES', 'callconvention-hard', 'armhf', 'armel', d)}"

EXTRA_OECMAKE += "-DKRNX_ARCHITECTURE=${KRNX_ARCHITECTURE}"
