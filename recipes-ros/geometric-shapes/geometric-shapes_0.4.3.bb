DESCRIPTION = "This package contains generic definitions of geometric shapes and bodies."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=5ee5b8b046ae48ad94a2037ca953a67b"

DEPENDS = "boost shape-msgs shape-tools octomap assimp libeigen qhull console-bridge random-numbers eigen-stl-containers resource-retriever"

SRC_URI = "https://github.com/ros-planning/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "050b4bb8eb25202269f3733ebbcd986f"
SRC_URI[sha256sum] = "9030b7713ca397852f7d0d19caf18ddd7c93ff0236c19e31d01e72e655bc407b"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
