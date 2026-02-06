# jazzy/ros-distro.inc
# General configuration settings that are dependent on ROS_DISTRO.
#
# Copyright (c) 2020-2021 LG Electronics, Inc.
# Copyright (c) 2025-2026 Wind River Systems, Inc.

ROS_DISTRO_CODENAME = "Jazzy Jalisco"

ROS2_DISTRO = "jazzy"

ROS_DISTRO_TYPE = "spaceros"
ROS_VERSION = "2"
# DO NOT OVERRIDE ROS_PYTHON_VERSION
ROS_PYTHON_VERSION = "3"

SPACEROS_RELEASE = "jazzy-2026.01.0"

# The platform release that the metadata for this ROS distro targets. This determines the versions of the platform packages that
# OE must provide. It must be one of the values of ROS_DISTRO_RELEASE_PLATFORMS (which is set in
# generated/superflore-ros-distro.inc).
ROS_DISTRO_BASELINE_PLATFORM = "ubuntu-noble"

require conf/ros-distro/include/jazzy/ros-distro-recipe-blacklist.inc
require conf/ros-distro/include/jazzy/ros-distro-preferred-versions.inc
require conf/ros-distro/include/jazzy/ros-distro-preferred-providers.inc

# Since ros-generate doesn't know when it's generating a recipe that it will be for a build tool, it can't know that what's in
# ROS_EXEC_DEPEND are also build tools. Manually add them here.
MASH_GENERATED_BUILDTOOLS = "\
    action-msgs-native\
    ament-clang-format-native\
    ament-clang-tidy-native\
    ament-cmake-auto-native\
    ament-cmake-core-native\
    ament-cmake-cppcheck-native\
    ament-cmake-cpplint-native\
    ament-cmake-export-definitions-native\
    ament-cmake-export-dependencies-native\
    ament-cmake-export-include-directories-native\
    ament-cmake-export-interfaces-native\
    ament-cmake-export-libraries-native\
    ament-cmake-export-link-flags-native\
    ament-cmake-export-targets-native\
    ament-cmake-flake8-native\
    ament-cmake-gen-version-h-native\
    ament-cmake-gmock-native\
    ament-cmake-google-benchmark-native\
    ament-cmake-gtest-native\
    ament-cmake-include-directories-native\
    ament-cmake-libraries-native\
    ament-cmake-native\
    ament-cmake-pep257-native\
    ament-cmake-pytest-native\
    ament-cmake-python-native\
    ament-cmake-ros-native\
    ament-cmake-target-dependencies-native \
    ament-cmake-test-native\
    ament-cmake-uncrustify-native\
    ament-cmake-vendor-package-native\
    ament-cmake-version-native\
    ament-cobra-native\
    ament-copyright-native\
    ament-cppcheck-native\
    ament-cpplint-native\
    ament-flake8-native\
    ament-ikos-native\
    ament-index-cpp-native\
    ament-index-python-native\
    ament-lint-cmake-native\
    ament-lint-native\
    ament-mypy-native\
    ament-package-native\
    ament-pclint-native\
    ament-pep257-native\
    ament-pycodestyle-native\
    ament-pyflakes-native\
    ament-uncrustify-native\
    ament-xmllint-native\
    builtin-interfaces-native\
    clang-native\
    cmake-native\
    cobra-vendor-native\
    composition-interfaces-native\
    cyclonedds-native\
    domain-coordinator-native\
    eigen3-cmake-module-native\
    fastrtps-cmake-module-native\
    generate-parameter-library-py-native\
    gcc-runtime-native\
    git-native\
    gmock-vendor-native\
    google-benchmark-native\
    google-benchmark-vendor-native\
    gtest-native\
    gtest-vendor-native\
    iceoryx-binding-c-native\
    ikos-native\
    launch-native\
    launch-ros-native\
    launch-testing-ament-cmake-native\
    launch-testing-native\
    launch-testing-ros-native\
    launch-xml-native\
    launch-yaml-native\
    libyaml-vendor-native\
    lifecycle-msgs-native\
    osrf-pycommon-native\
    pkgconfig-native\
    pybind11-vendor-native\
    python3-catkin-pkg-native\
    python3-empy-native\
    python3-native\
    python3-pytest-native\
    python3-setuptools-native\
    python3-vcstool-native\
    python-cmake-module-native\
    rcl-action-native\
    rcl-interfaces-native\
    rcl-lifecycle-native\
    rcl-logging-interface-native\
    rcl-logging-spdlog-native\
    rcl-native\
    rclpy-native\
    rcl-yaml-param-parser-native\
    rcpputils-native\
    rcutils-native\
    rmw-cyclonedds-cpp-native\
    rmw-cyclonedds-cpp-native\
    rmw-dds-common-native\
    rmw-implementation-cmake-native\
    rmw-implementation-native\
    ros2cli-native\
    ros2test-native\
    rosgraph-msgs-native\
    rosidl-adapter-native\
    rosidl-cli-native\
    rosidl-cmake-native\
    rosidl-core-generators-native\
    rosidl-core-runtime-native\
    rosidl-default-generators-native\
    rosidl-default-runtime-native\
    rosidl-generator-c-native\
    rosidl-generator-c-native\
    rosidl-generator-cpp-native\
    rosidl-generator-cpp-native\
    rosidl-generator-py-native\
    rosidl-generator-type-description-native\
    rosidl-parser-native\
    rosidl-pycommon-native\
    rosidl-runtime-c-native\
    rosidl-runtime-cpp-native\
    rosidl-typesupport-c-native\
    rosidl-typesupport-cpp-native\
    rosidl-typesupport-fastrtps-c-native\
    rosidl-typesupport-fastrtps-cpp-native\
    rosidl-typesupport-interface-native\
    rosidl-typesupport-introspection-c-native\
    rosidl-typesupport-introspection-cpp-native\
    rpyutils-native\
    service-msgs-native\
    service-msgs-native\
    spdlog-vendor-native\
    tracetools-native\
    type-description-interfaces-native\
    uncrustify-vendor-native\
    unique-identifier-msgs-native\
"

ROS_WORLD_SKIP_GROUPS += "connext"
