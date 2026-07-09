DESCRIPTION = "All supported packages from ROS 2 Humble"
LICENSE = "MIT"

inherit packagegroup
inherit ros_distro_${ROS_DISTRO}

PACKAGES = "${PN}"

# These are the packages tested for each Patch Release
RDEPENDS:${PN} = "\
        canopen \
        desktop-full \
        moveit \
        navigation2 \
        ros2-control \
"
