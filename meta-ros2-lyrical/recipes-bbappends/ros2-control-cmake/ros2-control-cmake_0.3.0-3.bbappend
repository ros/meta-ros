# Copyright (c) 2026 Wind River Systems, Inc.

# set_compiler_options() adds -Werror=... flags for every package that uses it.
# They are placed after CXXFLAGS on the compiler command line, so they can't be
# overridden with -Wno-error=... and they break the build with the toolchain's
# GCC, e.g. in the generated rosidl headers:
# time__traits.hpp:134:3: error: missing braces around initializer for 'std::__array_traits<std::basic_string_view<char>, 2>::_Type' [-Werror=missing-braces]
# exceptions.hpp:71:79: error: declaration of 'invalid_index' shadows a member of 'rclcpp::exceptions::InvalidNodeNameError' [-Werror=shadow]
# rolling_mean_accumulator.hpp:76:19: error: conversion from 'size_t' to 'double' may change value [-Werror=conversion]
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-Do-not-treat-compiler-warnings-as-errors.patch"
