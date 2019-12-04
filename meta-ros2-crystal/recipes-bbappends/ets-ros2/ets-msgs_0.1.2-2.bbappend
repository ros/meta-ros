# Copyright (c) 2019 LG Electronics, Inc.

# XXX Not sure why depending on "builtin-interfaces" fixes this do_configure() error:
#
# | CMake Error at .../BUILD/sysroots/x86_64-linux/usr/share/rosidl_typesupport_fastrtps_c/cmake/rosidl_typesupport_fastrtps_c-extras.cmake:6 (find_package):
# |   Could not find a configuration file for package "fastrtps" that is
# |   compatible with requested version "".
# |
# |   The following configuration files were considered but not accepted:
# |
# |     .../BUILD/sysroots/x86_64-linux/usr/share/fastrtps/cmake/fastrtps-config.cmake, version: 1.7.2 (64bit)
# |     .../BUILD/sysroots/x86_64-linux/usr/share/fastrtps/cmake/fastrtps-config.cmake, version: 1.7.2 (64bit)
#
# while adding "fastrtps" causes a native library to be linked with.

ROS_BUILD_DEPENDS += " \
    builtin-interfaces \
"
