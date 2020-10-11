DESCRIPTION = "ros2-demos package group"
LICENSE = "MIT"

inherit packagegroup
inherit ros_distro_${ROS_DISTRO}

PACKAGES = "${PN}"

RDEPENDS_${PN} = "\
        demo-nodes-cpp \
        ros2run \
        ros2topic \
"
