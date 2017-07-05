DESCRIPTION = "Provides conversions from PCL data types and ROS message types"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "cmake-modules pcl-msgs pcl roscpp"

SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "670605fa95f008ecc4c420cb9e53df44"
SRC_URI[sha256sum] = "79c107f2513fe0aa472b8eefc0cd652f0aaacaba482945acbf23c72d7d3bf5c8"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
