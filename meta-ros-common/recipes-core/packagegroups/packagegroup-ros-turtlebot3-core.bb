# Copyright (c) 2019 LG Electronics, Inc.

SUMMARY = "TurtleBot 3 packages that must be run on the device"

# Need this because the recipe uses MACHINE overrides.
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup
inherit ros_distro_${ROS_DISTRO}

TURTLEBOT3_PACKAGES_LIDAR ??= " \
    hls-lfcd-lds-driver \
"
TURTLEBOT3_PACKAGES_LIDAR_qemux86 = ""

# From just above here http://emanual.robotis.com/docs/en/platform/turtlebot3/appendix_raspi_cam/#run-raspicam-node (also see
# http://emanual.robotis.com/docs/en/platform/turtlebot3/applications/#turtlebot-panorama-demo):
TURTLEBOT3_PACKAGES_CAMERA_rpi ??= " \
    camera-info-manager \
    compressed-image-transport \
    raspicam-node \
"
# raspicam-node depends on userland to provide mmal, but for aarch64 it doesn't provide it.
TURTLEBOT3_PACKAGES_CAMERA_remove_aarch64 = "raspicam-node"

TURTLEBOT3_PACKAGES_CAMERA ??= ""

# From http://emanual.robotis.com/docs/en/platform/turtlebot3/raspberry_pi_3_setup/#3-install-dependent-packages-on-turtlebot-pc
RDEPENDS_${PN} = " \
    ros-base \
    turtlebot3-bringup \
    turtlebot3-msgs \
    ${TURTLEBOT3_PACKAGES_CAMERA} \
    ${TURTLEBOT3_PACKAGES_LIDAR} \
"

# Anticipate eventual TurtleBot 3 support under ROS 2, when the package names will be different.
RDEPENDS_${PN}_append_ros1-distro = " \
    rosserial-python \
    tf \
"

# "turtlebot3-bringup" expects "rosdep init; rosdep update" to have been done on the target. This is ROS 1 only.
RDEPENDS_${PN}_append_ros1-distro = " \
    python-rosdep-data \
"
