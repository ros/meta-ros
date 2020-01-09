# Copyright (c) 2020 LG Electronics, Inc.

# rosidl_generate_interfaces for some reason generates duplicate rules for every file
# and newer ninja fails because of that
EXTRA_OECMAKE_BUILD_append_task-compile = "-w dupbuild=warn"
EXTRA_OECMAKE_BUILD_append_task-install = "-w dupbuild=warn"
