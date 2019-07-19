# Copyright (c) 2019 LG Electronics, Inc.

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

# We need mmal for raspicam-node and mmal need vcsm from host_applications/linux/libs/sm/
SRC_URI_remove = "file://0001-Remove-EGL-dependency.patch"

SRC_URI_append = " file://0001-openmaxil-add-pkg-config-file.patch"
