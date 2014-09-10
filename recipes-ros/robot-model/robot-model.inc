SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "eda49f4a025e229be069622132f56eef"
SRC_URI[sha256sum] = "d9fa88f5cd904359041cd072fed59cb06f87537ab14c51c89605d1f04be58e9e"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "robot_model"
