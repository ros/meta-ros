DESCRIPTION = "octomap_ros provides conversion functions between ROS / PCL and OctoMap's native types."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "octomap-msgs octomap pcl-ros sensor-msgs tf"

SRC_URI = "https://github.com/OctoMap/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz \
           "
SRC_URI[md5sum] = "4cd3fd7f2f94567ab6d37ee0ae756573"
SRC_URI[sha256sum] = "6f4f90bbfe88c8314a406cfe70f0c4388d4d2d85a461d90911b2e6bf738ed153"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
