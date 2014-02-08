DESCRIPTION = "This package contains generic definitions of geometric shapes and bodies."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=5ee5b8b046ae48ad94a2037ca953a67b"

DEPENDS = "boost shape-msgs shape-tools octomap assimp libeigen qhull console-bridge random-numbers eigen-stl-containers resource-retriever"

SRC_URI = "https://github.com/ros-planning/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "53d43fd2d624c18d47789d1fcca26047"
SRC_URI[sha256sum] = "90dd882471147c981bf6395997d2b5318b970565cf5045c15bd0a5a4f465638c"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
