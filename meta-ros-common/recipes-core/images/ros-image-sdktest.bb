DESCRIPTION = "Image for testing meta-ros' SDK feature"

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

inherit core-image
inherit ros_distro_${ROS_DISTRO}
inherit ${ROS_DISTRO_TYPE}_image

IMAGE_ROOTFS_SIZE = "8192"

IMAGE_FEATURES += "ssh-server-openssh"

IMAGE_INSTALL_append_ros1-distro = " roslaunch rostopic roscpp-dev std-msgs-dev"
IMAGE_INSTALL_append_ros2-distro = " ros-core rclcpp-dev std-msgs-dev"

TOOLCHAIN_HOST_TASK += "nativesdk-cmake nativesdk-catkin"
