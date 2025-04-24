# Copyright (c) 2019 LG Electronics, Inc.
# Copyright (c) 2023-2025 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    python3-empy-native \
    python3-numpy-native \
    rcutils-native \
"

# ld: .../tmp-glibc/work/riscv64-oe-linux/rclcpp-components/28.1.5-1-r0/recipe-sysroot/opt/ros/jazzy/lib/librclcpp.so: undefined reference to `__atomic_exchange_1'
LDFLAGS:append:riscv64 = " -Wl,--no-as-needed -latomic -Wl,--as-needed"
LDFLAGS:append:riscv32 = " -Wl,--no-as-needed -latomic -Wl,--as-needed"
