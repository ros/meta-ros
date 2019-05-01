SRC_URI = "https://github.com/mavlink/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "88a94aeeeda9bc8f7e5b1997071464ac"
SRC_URI[sha256sum] = "92e086072ac0641143b59d1dbda7ab54e5903d55001eaeceb34432efe3b07dcc"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "mavros"
