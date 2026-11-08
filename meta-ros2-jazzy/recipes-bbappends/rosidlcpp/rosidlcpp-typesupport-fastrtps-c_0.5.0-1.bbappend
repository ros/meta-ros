# Copyright (c) 2026 Wind River Systems, Inc.

# rosidlcpp_typesupport_fastrtps_c.cpp:152:76:   required from here
# fmt/core.h:2593:45: error: 'fmt::v10::detail::type_is_unformattable_for<nlohmann::json_abi_v3_11_3::basic_json<>, char> _' has incomplete type
# fmt/core.h:1604:7: error: static assertion failed: Cannot format an argument. To make type T formattable provide a formatter<T> specialization
# fmt 10.2.1 cannot format a nlohmann::json value or a fmt::join() over a json array.
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://fix-fmt-json.patch"
