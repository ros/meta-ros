# Copyright (C) 2023 Avnet, Inc.  All rights reserved.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://fix_warning.patch"

# | CMake Error in CMakeLists.txt:
# |   Imported target "rclcpp::rclcpp" includes non-existent path
# |
# |     "/media/albertabeef/Rocinante/Avnet_2022_2/petalinux/projects/avnet-zub1cg_sbc-2022.2/build/tmp/work/cortexa72-cortexa53-xilinx-linux/v4l2-camera/0.4.0-1-r0/recipe-sysroot-native/usr/lib/python3.9/site-packages/numpy/core/include"
# |
# |   in its INTERFACE_INCLUDE_DIRECTORIES.  Possible reasons include:
# |
# |   * The path was deleted, renamed, or moved to another location.
# |
# |   * An install or uninstall procedure did not complete successfully.
# |
# |   * The installation package was faulty and references files it does not
# |   provide.
# |
# |
# |
# | -- Generating done
# | CMake Warning:
# |   Manually-specified variables were not used by the project:
# |
# |     CMAKE_EXPORT_NO_PACKAGE_REGISTRY
# |     CMAKE_INSTALL_BINDIR
# |     CMAKE_INSTALL_DATAROOTDIR
# |     CMAKE_INSTALL_INCLUDEDIR
# |     CMAKE_INSTALL_LIBDIR
# |     CMAKE_INSTALL_LIBEXECDIR
# |     CMAKE_INSTALL_LOCALSTATEDIR
# |     CMAKE_INSTALL_SBINDIR
# |     CMAKE_INSTALL_SHAREDSTATEDIR
# |     CMAKE_INSTALL_SYSCONFDIR
# |     LIB_SUFFIX
# |     PYTHON_EXECUTABLE
# |     PYTHON_SOABI
# |     Python_EXECUTABLE
# |
# |
# | CMake Generate step failed.  Build files cannot be regenerated correctly.

ROS_BUILDTOOL_DEPENDS += " \
    ament-cmake-ros-native \
    python3-numpy-native \
"


# v4l2-camera/0.7.0-1-r0/recipe-sysroot/usr/include/libstatistics_collector/libstatistics_collector/topic_statistics_collector/received_message_period.hpp:174:32: error: unused parameter 'message_info' [-Werror=unused-parameter]
CXXFLAGS += "-Wno-error=unused-parameter"
