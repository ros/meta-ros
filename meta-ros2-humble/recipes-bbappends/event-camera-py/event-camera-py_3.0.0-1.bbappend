# Copyright (c) 2024 Wind River Systems, Inc.

inherit python3targetconfig

# QA Issue:File was already stripped, this will prevent future debugging! [already-stripped]
INSANE_SKIP:${PN} += "already-stripped"

# rosidl_runtime_cpp/traits.hpp:131:8: error: 'template<class _Codecvt, class _Elem, class _Wide_alloc, class _Byte_alloc> class std::__cxx11::wstring_convert' is deprecated [-Werror=deprecated-declarations]
CXXFLAGS += "-Wno-error=deprecated-declarations"
