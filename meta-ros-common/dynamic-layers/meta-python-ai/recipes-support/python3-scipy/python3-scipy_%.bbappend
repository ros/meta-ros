# Copyright (c) 2026 Wind River Systems, Inc.

# ERROR Unmet dependencies (checked against .../recipe-sysroot-native/usr/bin/nativepython3):
#     meson-python<0.21.0,>=0.15.0
#         wanted: <0.21.0,>=0.15.0
#         found: 0.22.1
#     pybind11<3.1.0,>=2.13.2
#         wanted: <3.1.0,>=2.13.2
#         found: 3.1.0
# The upper bounds in scipy's pyproject.toml are marked as "pre-emptive only"
# upstream, so skip the build dependency check instead of downgrading.
PEP517_BUILD_OPTS:append = " --skip-dependency-check"
