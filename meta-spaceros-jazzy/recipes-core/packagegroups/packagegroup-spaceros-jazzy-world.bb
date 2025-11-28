# Copyright (c) 2025 Wind River Systems, Inc.

DESCRIPTION = "All packages from Space ROS"
LICENSE = "MIT"

inherit packagegroup
inherit ros_distro_jazzy

PACKAGES = "${PN}"

RDEPENDS:${PN} = "\
    packagegroup-spaceros-jazzy-core \
    packagegroup-spaceros-jazzy-moveit2 \
    packagegroup-spaceros-jazzy-nav2 \
"
