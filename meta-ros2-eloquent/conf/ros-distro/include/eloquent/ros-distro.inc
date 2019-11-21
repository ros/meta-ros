# eloquent/ros-distro.inc
# General configuration settings that are dependent on ROS_DISTRO.
#
# Copyright (c) 2019 LG Electronics, Inc.

ROS_DISTRO_CODENAME = "Eloquent Elusor"

# The platform release that the metadata for this ROS distro targets. This determines the versions of the platform packages that
# OE must provide. It must be one of the values of ROS_DISTRO_RELEASE_PLATFORMS (which is set in generated/ros-distro.inc).
ROS_DISTRO_BASELINE_PLATFORM = "ubuntu-bionic"

require conf/ros-distro/include/eloquent/generated/superflore-datetime.inc
require conf/ros-distro/include/eloquent/generated/ros-distro.inc
require conf/ros-distro/include/eloquent/ros-distro-recipe-blacklist.inc
require conf/ros-distro/include/eloquent/ros-distro-preferred-versions.inc
require conf/ros-distro/include/eloquent/ros-distro-preferred-providers.inc

# Override settings from generated/ros-distro.inc here.

# Since superflore doesn't know when it's generating a recipe that it will be for a build tool, it can't know that what's in
# ROS_EXEC_DEPEND are also build tools. Manually add them here.
ROS_SUPERFLORE_GENERATED_BUILDTOOLS += " \
    ament-lint-native \
    foonathan-memory-vendor-native \
    domain-coordinator-native \
    poco-vendor-native \
    rcpputils-native \
    rcutils-native \
    rmw-native \
    rmw-fastrtps-cpp-native \
    rmw-fastrtps-dynamic-cpp-native \
    rmw-fastrtps-shared-cpp-native \
    rmw-implementation-cmake-native \
    rmw-implementation-native \
    rosidl-actions-native \
    rosidl-adapter-native \
    rosidl-typesupport-fastrtps-c-native \
    uncrustify-vendor-native \
"

# https://github.com/ADLINK-IST/opensplice
ROS_UNRESOLVED_PLATFORM_PKG_libopensplice69 = ""
ROS_UNRESOLVED_PLATFORM_PKG_libopensplice69-native = ""

ROS_UNRESOLVED_PLATFORM_PKG_rti-connext-dds-5.3.1 = ""
ROS_UNRESOLVED_PLATFORM_PKG_rti-connext-dds-5.3.1-native = ""

ROS_UNRESOLVED_PLATFORM_PKG_python3-cryptography = "python3-cryptography"
#ROS_UNRESOLVED_PLATFORM_PKG_python3-ifcfg = "python3-ifcfg"
#ROS_UNRESOLVED_PLATFORM_PKG_python3-netifaces = "python3-netifaces"
ROS_UNRESOLVED_PLATFORM_PKG_python3-ifcfg = ""
ROS_UNRESOLVED_PLATFORM_PKG_python3-netifaces = ""

# XXX Temp until superflore fixed.
ROS_BUILD_TYPE_pn-fmilibrary-vendor = "ament_cmake"
ROS_BUILD_TYPE_pn-ml-classifiers = "ament_cmake"
ROS_BUILD_TYPE_pn-ros-workspace = "ament_cmake"
ROS_BUILD_TYPE_pn-sros2-cmake = "ament_cmake"
