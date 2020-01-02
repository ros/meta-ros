DESCRIPTION = "ros1-industrial-core package group"
LICENSE = "MIT"

inherit packagegroup

PACKAGES = "${PN}"

RDEPENDS_${PN} = "\
        industrial-trajectory-filters \
        industrial-robot-simulator \
        industrial-robot-client \
        industrial-utils \
"

# Depends on industrial-trajectory-filters->moveit-ros-planning->moveit-ros-perception->mesa with this restriction:
inherit distro_features_check
ANY_OF_DISTRO_FEATURES = "opengl vulkan"
