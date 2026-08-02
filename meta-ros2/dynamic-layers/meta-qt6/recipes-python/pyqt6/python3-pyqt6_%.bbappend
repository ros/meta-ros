# Copyright (c) 2026 Wind River Systems, Inc.
PYQT_MODULES:append = " QtWidgets"

# Qt 6 removed the standalone operator!= overload for QVariant in favor of
# C++20 operator rewriting (where a != b is automatically synthesized from
# !(a == b)). Force the compiler to allow GNU/C++17 standard extensions
# where these operators still resolve implicitly:
CXXFLAGS += "-std=c++17"
