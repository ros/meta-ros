SUMMARY = "ROS2 SDK Image"
DESCRIPTION = "${SUMMARY}"

inherit core-image
inherit ros_distro_${ROS_DISTRO}
inherit ${ROS_DISTRO_TYPE}_image

IMAGE_FEATURES:append = " \
"

IMAGE_INSTALL:append = " \
    packagegroup-core-boot \
    ${CORE_IMAGE_EXTRA_INSTALL} \
"

inherit core-image
inherit ros_distro_${ROS_DISTRO}
inherit ${ROS_DISTRO_TYPE}_image

TOOLCHAIN_HOST_TASK:append = " \
    nativesdk-ament-package \
    nativesdk-python3-colcon-common-extensions \
    nativesdk-python3-numpy \
    nativesdk-rosidl-adapter \
    nativesdk-rosidl-cli \
    nativesdk-rosidl-cmake \
    nativesdk-rosidl-default-generators \
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

TOOLCHAIN_TARGET_TASK:append = " \
    ament-package \
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
    ament-cmake-gmock \
    ament-cmake-gtest \
    ament-cmake-include-directories \
    ament-cmake-libraries \
    ament-cmake-pytest \
    ament-cmake-python \
    ament-cmake-ros \
    ament-cmake-target-dependencies \
    ament-cmake-test \
    ament-cmake-version \
    ament-cmake-gen-version-h \
    ament-lint-auto \
    foonathan-memory-staticdev \
    \
    nav-msgs \
    sensor-msgs \
    rclcpp \
    rclcpp-lifecycle \
    rclcpp-action \
    rclcpp-components \
    builtin-interfaces \
    fastrtps-cmake-module \
    rosidl-default-generators \
    rosidl-core-generators \
    rosidl-cmake \
    \
    ros-workspace \
"
