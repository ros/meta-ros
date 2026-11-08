# Copyright (c) 2026 Wind River Systems, Inc.

# generator_utils.cpp:278:21:   required from here
# fmt/core.h:1604:7: error: static assertion failed: Cannot format an argument. To make type T formattable provide a formatter<T> specialization
# fmt::join() over a nlohmann::json array is not formattable with fmt 10.2.1.
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://fix-fmt-join-json.patch"
