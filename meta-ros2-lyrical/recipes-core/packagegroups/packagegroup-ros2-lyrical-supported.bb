DESCRIPTION = "All supported packages from ROS 2 Lyrical"
LICENSE = "MIT"

inherit packagegroup
inherit ros_distro_${ROS_DISTRO}

PACKAGES = "${PN}"

# These are the packages tested for each Patch Release
# roboplan is not included: it needs python3-nanobind, python3-scikit-build-core and robin-map,
# which are not available in the scarthgap layers.
RDEPENDS:${PN} = "\
        apriltag-ros \
        canopen \
        desktop-full \
        geometry2 \
        geometry-tutorials \
        gps-umd \
        moveit \
        navigation2 \
        ros2-control \
        ros2-controllers \
        rosbag2 \
        ros-gz \
        ur \
"
