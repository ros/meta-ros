# Copyright (c) 2019-2020 LG Electronics, Inc.

# "rosidl-default-generators" belongs in ROS_BUILDTOOL_DEPENDS (as "rosidl-default-generators-native"); it should not be in
# ROS_BUILD_DEPENDS.
ROS_BUILDTOOL_DEPENDS += " \
    rosidl-default-generators-native \
"
ROS_BUILD_DEPENDS_remove = "rosidl-default-generators"

# rosidl_generate_interfaces for some reason generates duplicate rules for every file
# and newer ninja fails because of that
EXTRA_OECMAKE_BUILD_append_task-compile = "-w dupbuild=warn"
EXTRA_OECMAKE_BUILD_append_task-install = "-w dupbuild=warn"
