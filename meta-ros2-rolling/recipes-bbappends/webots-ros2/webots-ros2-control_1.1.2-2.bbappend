# Copyright (c) 2021 LG Electronics, Inc.

# Depends on webots-ros2-driver which contains prebuilt binaries only for x86-64 (darwin, msys and linux):
COMPATIBLE_MACHINE = "(^$)"
COMPATIBLE_MACHINE:x86-64 = "(.*)"
