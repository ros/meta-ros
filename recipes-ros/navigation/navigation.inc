SRC_URI = "https://github.com/ros-planning/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "0430ae5e223dea3ce7b8dd817d04f531"
SRC_URI[sha256sum] = "d41859d881498a0432b87a38704983dcaef8a9b99ba8f710781be101e1f7c968"

SRC_URI += "file://0001-amcl-fix-compilation-with-gcc-v7.patch;patchdir=.."

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "navigation"
