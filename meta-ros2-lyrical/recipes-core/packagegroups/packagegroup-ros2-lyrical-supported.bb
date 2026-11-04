DESCRIPTION = "All supported packages from ROS 2 Lyrical"
LICENSE = "MIT"

inherit packagegroup
inherit ros_distro_${ROS_DISTRO}

PACKAGES = "${PN}"

# These are the packages tested for each Patch Release
RDEPENDS:${PN} = "\
        apriltag-ros \
        canopen \
        desktop-full \
        geometry2 \
        geometry-tutorials \
        gps-umd \
        moveit \
        navigation2 \
        roboplan \
        ros2-control \
        ros2-controllers \
        rosbag2 \
        ros-gz \
        ur \
"
