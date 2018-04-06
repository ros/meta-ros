SRC_URI = "https://github.com/ros-planning/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "5b6b54e43c0693295a634c4a58cfecc7"
SRC_URI[sha256sum] = "7396ce129cfc8262dcb748ea722ec83496c530331bb7a950930050813b30ce8c"

SRC_URI += "file://0001-amcl-fix-compilation-with-gcc-v7.patch;patchdir=.."

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "navigation"
