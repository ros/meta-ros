# dashing/ros-distro.inc
# General configuration settings that are dependent on ROS_DISTRO.
#
# Copyright (c) 2019 LG Electronics, Inc.

ROS_DISTRO_CODENAME = "Dashing Diademata"

# The platform release that the metadata for this ROS distro targets. This determines the versions of the platform packages that
# OE must provide. It must be one of the values of ROS_DISTRO_RELEASE_PLATFORMS (which is set in
# generated/superflore-ros-distro.inc).
ROS_DISTRO_BASELINE_PLATFORM = "ubuntu-bionic"

require conf/ros-distro/include/dashing/generated/superflore-datetime.inc
require conf/ros-distro/include/dashing/generated/superflore-ros-distro.inc
require conf/ros-distro/include/dashing/ros-distro-recipe-blacklist.inc
require conf/ros-distro/include/dashing/ros-distro-preferred-versions.inc
require conf/ros-distro/include/dashing/ros-distro-preferred-providers.inc

# Override settings from generated/superflore-ros-distro.inc here.

# Since superflore doesn't know when it's generating a recipe that it will be for a build tool, it can't know that what's in
# ROS_EXEC_DEPEND are also build tools. Manually add them here.
ROS_SUPERFLORE_GENERATED_BUILDTOOLS += " \
    ament-lint-native \
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

# Used by generated-recipes/geographic-info/geodesy_1.0.1-1.bb
# use python3 version because python2 is EOL
ROS_UNRESOLVED_PLATFORM_PKG_python-pyproj = "python3-pyproj"

# Used by generated-recipes/phidgets-drivers/libphidget22_2.0.1-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libusb-1.0 = "libusb1"

# Used by generated-recipes/marti-common/swri-transform-util_3.0.3-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_proj = "proj"

# Used by generated-recipes/rosbridge-suite/rosbridge-library_1.0.2-1.bb
# and bson is now provided by pymongo
ROS_UNRESOLVED_PLATFORM_PKG_python3-bson = "python3-pymongo"

# Used by generated-recipes/teleop-tools/mouse-teleop_1.0.1-1.bb
# use python3 version because python2 is EOL
ROS_UNRESOLVED_PLATFORM_PKG_python-tk = "python3-tkinter"

# Used by generated-recipes/hls-lfcd-lds-driver/hls-lfcd-lds-driver_2.0.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libboost-system-dev = "boost"

# Used by generated-recipes/navigation2/nav2-util_0.2.6-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libboost-program-options = "boost"

# Used by generated-recipes/marti-common/swri-geometry-util_3.0.3-1.bb
# generated-recipes/marti-common/swri-transform-util_3.0.3-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libgeos++-dev = "geos"

# Used by generated-recipes/rosbridge-suite/rosbridge-library_1.0.2-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python3-pil = "python3-pillow"

# Used by generated-recipes/kinesis-manager/kinesis-manager_2.0.1-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_log4cplus = "log4cplus"

# Used by generated-recipes/gps-umd/gpsd-client_1.0.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libgps = "gpsd"

# Used by generated-recipes/navigation2/nav2-map-server_0.2.6-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_graphicsmagick = "graphicsmagick"

# Used by generated-recipes/navigation2/nav2-system-tests_0.2.6-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_lcov = "lcov"

# Used by generated-recipes/rosbridge-suite/rosbridge-server_1.0.2-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python3-twisted = "python3-twisted"

# XXX Temp until superflore fixed.
# Must use a _pn- override in this file to override the ROS_BUILD_TYPE of a generated recipe,
# because we need to set this variable before the "inherit" line in the recipe is parsed,
# and having it in a .bbappend sets it too late.
ROS_BUILD_TYPE_pn-async-web-server-cpp = "ament_cmake"
ROS_BUILD_TYPE_pn-fmilibrary-vendor = "ament_cmake"
ROS_BUILD_TYPE_pn-geographic-info = "ament_cmake"
ROS_BUILD_TYPE_pn-gps-umd = "ament_cmake"
ROS_BUILD_TYPE_pn-ml-classifiers = "ament_cmake"
ROS_BUILD_TYPE_pn-ros-workspace = "ament_cmake"
ROS_BUILD_TYPE_pn-sros2-cmake = "ament_cmake"
ROS_BUILD_TYPE_pn-web-video-server = "ament_cmake"
