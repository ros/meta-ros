# Copyright (c) 2020 Intel Corp.

# New patch file to fix upsteam issue #737
# during do_configure
FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-update-moveit_plugins.patch \
"
