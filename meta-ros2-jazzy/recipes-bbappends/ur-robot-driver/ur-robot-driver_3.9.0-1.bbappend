# Copyright (c) 2023 Wind River Systems, Inc.

# ERROR: QA Issue: /usr/lib/ur_robot_driver/start_ursim.sh contained in package ur-robot-driver requires /bin/bash, but no providers found in RDEPENDS:ur-robot-driver? [file-rdeps]
RDEPENDS:${PN} += "bash"

# ur-robot-driver/3.9.0-1/recipe-sysroot/opt/ros/jazzy/include/rcutils/rcutils/logging_macros.h:56:27: error: format not a string literal and no format arguments [-Werror=format-security]
# urscript_interface.cpp passes exc.what() to RCLCPP_ERROR() as the format string
CXXFLAGS += "-Wno-error=format-security"
