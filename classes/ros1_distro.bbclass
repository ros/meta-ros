# Copyright (c) 2019 LG Electronics, Inc.

inherit ros_distro

# Place metadata unique to ROS 1 distros here.

# ROS 1 distros contain only "ros1" type components
def ros_distro__get_component_type(component, d):
    return 'ros1'

# *.cmake files have hardcoded sysroot-s in them.
SSTATE_SCAN_FILES_append = " *.cmake"
