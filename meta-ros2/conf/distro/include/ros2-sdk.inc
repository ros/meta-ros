# Copyright (c) 2024 Qualcomm Innovation Center, Inc. All rights reserved

# native packages in SDK
TOOLCHAIN_HOST_TASK:append = " \
    nativesdk-ament-package \
    nativesdk-python3-colcon-common-extensions \
    nativesdk-python3-numpy \
    nativesdk-rosidl-adapter \
    nativesdk-rosidl-cli \
    nativesdk-rosidl-cmake \
    nativesdk-rosidl-generator-c \
    nativesdk-rosidl-generator-cpp \
    nativesdk-rosidl-parser \
    nativesdk-rosidl-typesupport-c \
    nativesdk-rosidl-typesupport-cpp \
    nativesdk-rosidl-typesupport-fastrtps-c \
    nativesdk-rosidl-typesupport-fastrtps-cpp \
    nativesdk-rosidl-typesupport-introspection-c \
    nativesdk-rosidl-typesupport-introspection-cpp \
"

# target packages in SDK
TOOLCHAIN_TARGET_TASK:append = " \
    ament-cmake \
    ament-cmake-auto \
    ament-cmake-core \
    ament-cmake-export-definitions \
    ament-cmake-export-dependencies \
    ament-cmake-export-include-directories \
    ament-cmake-export-interfaces \
    ament-cmake-export-libraries \
    ament-cmake-export-link-flags \
    ament-cmake-export-targets \
    ament-cmake-gen-version-h \
    ament-cmake-gmock \
    ament-cmake-google-benchmark \
    ament-cmake-gtest \
    ament-cmake-include-directories \
    ament-cmake-libraries \
    ament-cmake-nose \
    ament-cmake-pytest \
    ament-cmake-python \
    ament-cmake-ros \
    ament-cmake-target-dependencies \
    ament-cmake-test \
    ament-cmake-version \
    ament-lint-auto \
    foonathan-memory-staticdev \
"
