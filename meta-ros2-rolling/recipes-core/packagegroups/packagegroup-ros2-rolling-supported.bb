DESCRIPTION = "All supported packages from ROS 2 Rolling"
LICENSE = "MIT"

inherit packagegroup
inherit ros_distro_${ROS_DISTRO}

PACKAGES = "${PN}"

# These are the packages tested for each Patch Release
RDEPENDS:${PN} = "\
        canopen \
        desktop-full \
        ros2-control \
"
# navigation2 does not yet exist in ROS 2 Rolling
# moveit2 does not yet exist in ROS 2 Rolling
