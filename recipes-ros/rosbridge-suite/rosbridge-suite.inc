SRC_URI = "https://github.com/RobotWebTools/rosbridge_suite/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "710473c412c77a4d212478e2e1f6c678"
SRC_URI[sha256sum] = "c26130590ed36d899dc4a2f3282caec96fadc75732cd5c3364e3210139d85820"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "rosbridge_suite"
