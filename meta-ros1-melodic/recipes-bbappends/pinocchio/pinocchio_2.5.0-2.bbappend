# Copyright (c) 2020 LG Electronics, Inc.

inherit pythonnative

# Fails to build because of eigenpy.pc issues and even with this fixed it later fails with:
# bindings/python/pinocchio/libpinocchio_pywrap.so: error: undefined reference to 'boost::python::detail::init_module(char const*, void (*)())'
# that's because boost was built with python37 support, while pinocchio uses python27 and init_module is different, see:
# #  if PY_VERSION_HEX >= 0x03000000
# BOOST_PYTHON_DECL PyObject* init_module(PyModuleDef&, void(*)());
# #else
# BOOST_PYTHON_DECL PyObject* init_module(char const* name, void(*)());
# #endif
# pinocchio/2.3.1-1-r0/build$ ../recipe-sysroot-native/usr/bin/arm-webos-linux-gnueabi/arm-webos-linux-gnueabi-gcc-nm -D ../recipe-sysroot/usr/lib/libboost_python37.so.1.68.0 | grep init_module
# 0001e018 T _ZN5boost6python6detail11init_moduleER11PyModuleDefPFvvE
# Similar issue described here:
# https://stackoverflow.com/questions/5810101/undefined-boost-python-symbol-boostpythondetailinit-module
EXTRA_OECMAKE += "-DBUILD_PYTHON_INTERFACE=OFF"

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package contains symlink .so: pinocchio path '/work/core2-64-oe-linux/pinocchio/2.4.0-2-r0/packages-split/pinocchio/usr/lib/libpinocchio.so' [dev-so]
inherit ros_insane_dev_so
