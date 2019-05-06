DESCRIPTION = "All non-test packages for the target from files/${ROS_DISTRO}/cache.yaml"
LICENSE = "MIT"

inherit packagegroup
inherit ros_distro_${ROS_DISTRO}

PACKAGES = "${PN}"

RDEPENDS_${PN} = "${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES}"

# Allow the above settings to be overridden.
include ${PN}-${ROS_DISTRO}.inc
