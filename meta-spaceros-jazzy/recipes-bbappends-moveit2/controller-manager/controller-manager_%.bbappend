# Copyright (c) 2021 LG Electronics, Inc.
# Copyright (c) 2022 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    ament-cmake-ros-native \
    python3-numpy-native \
    rosidl-adapter-native \
    rosidl-generator-c-native \
    rosidl-generator-cpp-native \
    rosidl-generator-py-native \
    rosidl-typesupport-cpp-native \
    rosidl-typesupport-fastrtps-c-native \
    rosidl-typesupport-fastrtps-cpp-native \
    rosidl-typesupport-introspection-cpp-native \
    generate-parameter-library-py-native \
"

# ld: .../libpal_statistics.so: undefined reference to `__atomic_compare_exchange_16'
# ld: .../libpal_statistics.so: undefined reference to `__atomic_store_16'
# ld: .../libpal_statistics.so: undefined reference to `__atomic_load_16'
# collect2: error: ld returned 1 exit status
LDFLAGS:append:riscv32 = " -Wl,--no-as-needed -latomic -Wl,--as-needed"
LDFLAGS:append:riscv64 = " -Wl,--no-as-needed -latomic -Wl,--as-needed"

# QA Issue: /opt/ros/jazzy/lib/controller_manager/unspawner maximum shebang size exceeded, the maximum size is 128. [shebang-size]
# QA Issue: /opt/ros/jazzy/lib/controller_manager/hardware_spawner maximum shebang size exceeded, the maximum size is 128. [shebang-size]
# QA Issue: /opt/ros/jazzy/lib/controller_manager/spawner maximum shebang size exceeded, the maximum size is 128. [shebang-size]
do_install:append() {
    # Modify the Python scripts to use the runtime path to Python
    sed -i -e '1s|^#!.*|#!/usr/bin/env python3|' ${D}${ros_libdir}/controller_manager/unspawner
    sed -i -e '1s|^#!.*|#!/usr/bin/env python3|' ${D}${ros_libdir}/controller_manager/hardware_spawner
    sed -i -e '1s|^#!.*|#!/usr/bin/env python3|' ${D}${ros_libdir}/controller_manager/spawner
}
