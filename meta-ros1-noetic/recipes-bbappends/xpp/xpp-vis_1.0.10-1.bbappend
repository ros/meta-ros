# Copyright (c) 2020-2021 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-add-missing-tf-kdl_parser-to-CATKIN_D.patch \
    file://0002-urdf_visualizer-fix-build-with-newer-robot_state_pub.patch \
"
