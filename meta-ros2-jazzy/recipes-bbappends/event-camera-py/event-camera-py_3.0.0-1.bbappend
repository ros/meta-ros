# Copyright (c) 2024 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-default-runtime-native \
"
# ERROR: event-camera-py-3.0.0-1-r0 do_package: QA Issue: File '/opt/ros/jazzy/lib/python3.12/site-packages/event_camera_py/_event_camera_py.cpython-312-x86_64-linux-gnu.so' from event-camera-py was already stripped, this will prevent future debugging! [already-stripped]
INSANE_SKIP:${PN} += "already-stripped"
