SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "5d55aa4d8b5fea53e0fc72605843b4d0"
SRC_URI[sha256sum] = "8c8e20d28d352b3ccb227ca7da39a1dddc051cf8309f90a46d6b0c7b2e398d33"

SRC_URI += "file://0001-find-Eigen-with-cmake_modules-Find-script-partly-rev.patch;patchdir=.."

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "geometry"
