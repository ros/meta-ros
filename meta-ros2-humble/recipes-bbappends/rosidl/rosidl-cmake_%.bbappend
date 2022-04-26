# Copyright (c) 2022 Acceleration Robotics, S.L.

# ERROR: rosidl-cmake-3.1.3-1-r0 do_package: QA Issue: rosidl-cmake: Files/directories were installed but not shipped in any package
FILES:${PN}:prepend = " \
    ${WORKDIR}/recipe-sysroot-native/usr/lib/python3.9/site-packages/rosidl_cmake-3.1.3-py3.9.egg-info \
    ${WORKDIR}/recipe-sysroot-native/usr/lib/python3.9/site-packages/rosidl_cmake \
"
