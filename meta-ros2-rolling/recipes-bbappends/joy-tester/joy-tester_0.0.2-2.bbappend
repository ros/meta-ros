# Copyright (c) 2023 Wind River Systems, Inc.

# python3 RPROVIDES python3-tkinter
ROS_BUILD_DEPENDS:remove = " \
    python3-tkinter \
"
ROS_EXPORT_DEPENDS:remove = " \
    python3-tkinter \
"
ROS_BUILD_DEPENDS += " \
    python3 \
"
