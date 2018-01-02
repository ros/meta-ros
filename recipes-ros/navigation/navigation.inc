SRC_URI = "https://github.com/ros-planning/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "25918a8c5e9b64a74ed7776fcd9419cd"
SRC_URI[sha256sum] = "0f98fae839023002769f4cbd770db87ad3ab9dd02faae7feda492fd38bda1407"

SRC_URI += "file://0001-amcl-fix-compilation-with-gcc-v7.patch;patchdir=.."

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "navigation"
