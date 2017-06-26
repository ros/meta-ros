SRC_URI = "https://github.com/ros-planning/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "d7a392da183b3c2a5fce063e90cbf1f2"
SRC_URI[sha256sum] = "169f89a4a3a94437ffbf80a9b06b65471c17529169d1940a217e92d85481f18f"

SRC_URI += "file://0001-address-gcc6-build-error.patch;patchdir=.. \
            file://0001-amcl-fix-compilation-with-gcc-v7.patch;patchdir=.."

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "navigation"
