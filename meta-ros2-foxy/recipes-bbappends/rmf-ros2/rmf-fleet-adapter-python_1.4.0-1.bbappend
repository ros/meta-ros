# Copyright (c) 2021 LG Electronics, Inc.

DEPENDS += " \
    ament-package-native \
    python3-catkin-pkg-native \
"

FILES:${PN} += "${libdir}/python"

# more dependencies as in
# meta-ros2-rolling/recipes-bbappends/rmf-task/rmf-task_1.0.0-1.bbappend
# because the rmf-task in foxy doesn't need this, but rmf-fleet-adapter-python
# does and rmf-task doesn't pull it into dependency tree here
DEPENDS += " \
    ament-cmake \
    ament-cmake-core \
    ament-cmake-libraries \
    ament-cmake-export-definitions \
    ament-cmake-export-include-directories \
    ament-cmake-export-interfaces \
    ament-cmake-export-libraries \
    ament-cmake-export-link-flags \
    ament-cmake-export-targets \
    ament-cmake-python \
    ament-cmake-target-dependencies \
    ament-cmake-include-directories \
    ament-cmake-test \
    ament-cmake-version \
    ament-package-native \
    python3-catkin-pkg-native \
    rosidl-typesupport-introspection-c \
    rosidl-typesupport-introspection-cpp \
    rosidl-typesupport-c \
    rosidl-runtime-cpp \
"

inherit python3native

DEPENDS += " \
    pybind11-vendor \
"
