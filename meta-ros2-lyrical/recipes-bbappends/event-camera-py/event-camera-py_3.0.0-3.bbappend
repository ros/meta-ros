# Copyright (c) 2024 Wind River Systems, Inc.

inherit python3targetconfig

ROS_BUILDTOOL_DEPENDS += "\
    rosidl-default-runtime-native \
"

# rosidl_runtime_cpp/traits.hpp:132:8: error: 'template<class _Codecvt, class _Elem, class _Wide_alloc, class _Byte_alloc> class std::__cxx11::wstring_convert' is deprecated [-Werror=deprecated-declarations]
CXXFLAGS += "-Wno-error=deprecated-declarations"

# ERROR: event-camera-py-3.0.0-3-r0 do_package: QA Issue: File '/opt/ros/lyrical/lib/python3.14/site-packages/event_camera_py/_event_camera_py.cpython-314-x86_64-linux-gnu.so' from event-camera-py was already stripped, this will prevent future debugging! [already-stripped]
INSANE_SKIP:${PN} += "already-stripped"
