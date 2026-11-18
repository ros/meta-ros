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

# meta-python-ai makes the target build depend on python3-scipy-native. That
# pulls in a whole native scipy build, openblas-native and, through them, a
# host gfortran (F90:class-native = "${FC}"). The target build does not need
# it: it configures and compiles without python3-scipy-native in the sysroot
# (verified with hpp-fcl -> eigenpy -> python3-scipy on jazzy).
DEPENDS:remove:class-target = "python3-scipy-native"
