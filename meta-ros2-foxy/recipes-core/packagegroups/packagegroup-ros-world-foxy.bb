# Copyright (c) 2020 LG Electronics, Inc.

DESCRIPTION = "All non-test packages for the target from files/foxy/cache.yaml"
LICENSE = "MIT"

inherit packagegroup
inherit ros_distro_foxy

PACKAGES = "${PN}"

RDEPENDS_${PN} = "${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES}"
