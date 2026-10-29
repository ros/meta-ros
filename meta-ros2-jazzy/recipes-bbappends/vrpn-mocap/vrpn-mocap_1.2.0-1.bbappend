# Copyright (c) 2023 Wind River Systems, Inc.

# ERROR: vrpn-mocap-1.0.4-1-r0 do_package_qa: QA Issue: non -staticdev package contains static .a library: vrpn-mocap path '/usr/lib/vrpn_mocap/libvrpn_mocap.a' [staticdev]
# ERROR: vrpn-mocap-1.0.4-1-r0 do_package_qa: Fatal QA errors were found, failing task.
FILES:${PN}-staticdev += "${libdir}/${ROS_BPN}/libvrpn_mocap.a"
