# Copyright (c) 2020 LG Electronics, Inc.

# angles dependency should be used only when catkin testing
# is enabled, which in our builds isn't
FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-trajectory_processing-remove-unnecessary-angles-angl.patch"
