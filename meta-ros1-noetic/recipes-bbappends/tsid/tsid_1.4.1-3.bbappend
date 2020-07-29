# Copyright (c) 2020 LG Electronics, Inc.

# |   /jenkins/mjansa/build/ros/ros1-melodic-dunfell/tmp-glibc/work/core2-64-oe-linux/tsid/1.4.1-3-r0/recipe-sysroot-native/usr/share/cmake-3.16/Modules/FindPython3.cmake:300 (include)
# |   cmake/python.cmake:92 (FIND_PACKAGE)
# |   CMakeLists.txt:85 (FINDPYTHON
inherit python3native

# | CMake Error: TRY_RUN() invoked in cross-compiling mode, please set the following cache variables appropriately:
# |    _cxx_standard_run_status (advanced)
# |    _cxx_standard_run_status__TRYRUN_OUTPUT (advanced)
EXTRA_OECMAKE += "-D_cxx_standard_run_status=0 -D_cxx_standard_run_status__TRYRUN_OUTPUT=201402"

# | CMake Error in bindings/python/CMakeLists.txt:
# |   Imported target "eigenpy::eigenpy" includes non-existent path
# | 
# |     "/jenkins/mjansa/build/ros/ros1-melodic-dunfell/tmp-glibc/work/core2-64-oe-linux/tsid/1.4.1-3-r0/recipe-sysroot-native/usr/lib/python2.7/site-packages/numpy/core/include"
# | 
# |   in its INTERFACE_INCLUDE_DIRECTORIES.  Possible reasons include:
# | 
# |   * The path was deleted, renamed, or moved to another location.
DEPENDS += "python-numpy-native"

# ERROR: tsid-1.4.1-3-r0 do_package_qa: QA Issue: non -dev/-dbg/nativesdk- package contains symlink .so: tsid path '/work/core2-64-oe-linux/tsid/1.4.1-3-r0/packages-split/tsid/usr/lib/libtsid.so' [dev-so]
inherit ros_insane_dev_so
