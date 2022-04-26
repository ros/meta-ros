# Copyright (c) 2022 Acceleration Robotics, S.L.

# ERROR: rosidl-parser-3.1.3-1-r0 do_package: QA Issue: rosidl-parser: Files/directories were installed but not shipped in any package
FILES:${PN}:prepend = " \
    ${WORKDIR}/recipe-sysroot-native/usr/lib/python3.9/site-packages/rosidl_parser-3.1.3-py3.9.egg-info \
    ${WORKDIR}/recipe-sysroot-native/usr/lib/python3.9/site-packages/rosidl_parser \
"
