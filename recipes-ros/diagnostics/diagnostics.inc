SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "ba9daddff40fcaf43e3b455b4cc85ec0"
SRC_URI[sha256sum] = "094039caf478f5b57d2781184d9759ae5f8ff96c7476d7a41095af7bef9dbcfa"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "diagnostics"
