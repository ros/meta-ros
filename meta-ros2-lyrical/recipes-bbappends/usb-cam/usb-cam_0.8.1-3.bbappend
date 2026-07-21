# Copyright (c) 2021 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

LICENSE = "BSD-3-Clause"

SRC_URI:append = " \
    file://0001-Remove-deprecared-avcodec_close.patch \
    file://0002-remove-AV_PIX_FMT_XVMC.patch \
"

# usb-cam/0.8.1-1/recipe-sysroot/opt/ros/rolling/include/rosidl_runtime_cpp/rosidl_runtime_cpp/traits.hpp:132:8: error: 'template<class _Codecvt, class _Elem, class _Wide_alloc, class _Byte_alloc> class std::__cxx11::wstring_convert' is deprecated [-Werror=deprecated-declarations]
#|   132 |   std::wstring_convert<std::codecvt_utf8_utf16<char16_t>, char16_t> convert;
CXXFLAGS += "-Wno-error=deprecated-declarations"

inherit pkgconfig

