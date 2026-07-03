# Copyright (c) 2023 Wind River Systems, Inc.

# Could NOT find PkgConfig (missing: PKG_CONFIG_EXECUTABLE)
inherit pkgconfig

# Could NOT find Boost: missing: python2.7 numpy2.7 (found .../lanelet2-examples/1.2.1-1-r0/recipe-sysroot/usr/lib/cmake/Boost-1.78.0/BoostConfig.cmake (found version "1.78.0"))
# Could NOT find Boost: missing: python numpy (found .../lanelet2-examples/1.2.1-1-r0/recipe-sysroot/usr/lib/cmake/Boost-1.78.0/BoostConfig.cmake (found version "1.78.0"))
EXTRA_OECMAKE = " \
    -DPYTHON_VERSION=${PYTHON_BASEVERSION} \
    -DPython3_VERSION=${PYTHON_BASEVERSION} \
"
