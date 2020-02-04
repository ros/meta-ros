# eloquent/ros-distro.inc
# General configuration settings that are dependent on ROS_DISTRO.
#
# Copyright (c) 2019 LG Electronics, Inc.

ROS_DISTRO_CODENAME = "Eloquent Elusor"

# The platform release that the metadata for this ROS distro targets. This determines the versions of the platform packages that
# OE must provide. It must be one of the values of ROS_DISTRO_RELEASE_PLATFORMS (which is set in
# generated/superflore-ros-distro.inc).
ROS_DISTRO_BASELINE_PLATFORM = "ubuntu-bionic"

require conf/ros-distro/include/eloquent/generated/superflore-datetime.inc
require conf/ros-distro/include/eloquent/generated/superflore-ros-distro.inc
require conf/ros-distro/include/eloquent/ros-distro-recipe-blacklist.inc
require conf/ros-distro/include/eloquent/ros-distro-preferred-versions.inc
require conf/ros-distro/include/eloquent/ros-distro-preferred-providers.inc

# Override settings from generated/superflore-ros-distro.inc here.

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

ROS_UNRESOLVED_PLATFORM_PKG_python3-mypy = "python3-mypy"

ROS_UNRESOLVED_PLATFORM_PKG_python3-future = "python3-future"

# Used by generated-recipes/geographic-info/geodesy_1.0.1-1.bb
# use python3 version because python2 is EOL
ROS_UNRESOLVED_PLATFORM_PKG_python-pyproj = "python3-pyproj"

# Used by generated-recipes/teleop-tools/mouse-teleop_1.0.1-1.bb
# use python3 version because python2 is EOL
ROS_UNRESOLVED_PLATFORM_PKG_python-tk = "python3-tkinter"

# python3 bindings are provided by lttng-tools when python PACKAGECONFIG is enabled there
ROS_UNRESOLVED_PLATFORM_PKG_python3-lttng = "lttng-tools"

ROS_UNRESOLVED_PLATFORM_PKG_spdlog = "spdlog"

# Used by generated-recipes/phidgets-drivers/libphidget22_2.0.1-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libusb-1.0 = "libusb1"

# Used by generated-recipes/spatio-temporal-voxel-layer/spatio-temporal-voxel-layer_2.1.2-2.bb
ROS_UNRESOLVED_PLATFORM_PKG_tbb = "tbb"

# Used by generated-recipes/navigation2/nav2-map-server_0.3.2-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_graphicsmagick = "graphicsmagick"

# Used by generated-recipes/kobuki-ftdi/kobuki-ftdi_1.0.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libusb-dev = "libusb1"
ROS_UNRESOLVED_PLATFORM_PKG_libftdi-dev = "libftdi"
ROS_UNRESOLVED_PLATFORM_PKG_ftdi-eeprom = "libftdi"

# Used by generated-recipes/popf/popf_0.0.11-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_flex = "flex"
ROS_UNRESOLVED_PLATFORM_PKG_bison = "bison"

# Used by generated-recipes/ament-virtualenv/ament-virtualenv_0.0.5-6.bb
ROS_UNRESOLVED_PLATFORM_PKG_python3-packaging = "python3-packaging"
ROS_UNRESOLVED_PLATFORM_PKG_python3-packaging-native = "python3-packaging-native"
ROS_UNRESOLVED_PLATFORM_PKG_python-virtualenv = "python3-virtualenv"
ROS_UNRESOLVED_PLATFORM_PKG_python-virtualenv-native = "python3-virtualenv-native"

# XXX Temp until superflore fixed.
# Must use a _pn- override in this file to override the ROS_BUILD_TYPE of a generated recipe,
# because we need to set this variable before the "inherit" line in the recipe is parsed,
# and having it in a .bbappend sets it too late.
ROS_BUILD_TYPE_pn-automotive-autonomy-msgs = "ament_cmake"
ROS_BUILD_TYPE_pn-automotive-navigation-msgs = "ament_cmake"
ROS_BUILD_TYPE_pn-automotive-platform-msgs = "ament_cmake"
ROS_BUILD_TYPE_pn-fmilibrary-vendor = "ament_cmake"
ROS_BUILD_TYPE_pn-geographic-info = "ament_cmake"
ROS_BUILD_TYPE_pn-ml-classifiers = "ament_cmake"
ROS_BUILD_TYPE_pn-ros-workspace = "ament_cmake"
ROS_BUILD_TYPE_pn-sros2-cmake = "ament_cmake"
