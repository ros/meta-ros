DESCRIPTION = "octomap_ros provides conversion functions between ROS / PCL and OctoMap's native types."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "octomap-msgs octomap pcl-ros sensor-msgs tf"

SRC_URI = "https://github.com/OctoMap/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "a72a025e3c144e2db7bd0ff0d6775fee"
SRC_URI[sha256sum] = "f39877bc3595f0d3808762042aee2c2cdc50ad8db6032beac31995da70c0b62b"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
