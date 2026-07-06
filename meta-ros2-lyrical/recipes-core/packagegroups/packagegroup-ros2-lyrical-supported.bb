DESCRIPTION = "All supported packages from ROS 2 Lyrical"
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
# navigation2 does not yet exist in ROS 2 Lyrical
#   https://github.com/ros-navigation/navigation2/issues/6123
# moveit2 does not yet exist in ROS 2 Lyrical
#   https://github.com/moveit/moveit2/issues/3717
