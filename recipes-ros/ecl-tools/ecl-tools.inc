SRC_URI = "https://github.com/stonier/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "f4c840f4336bda84b201aa820e285b6b"
SRC_URI[sha256sum] = "8004f61d183369ccbb1daebae86f207e91c0161629d41e6113c1aacc8cee332d"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ecl_tools"
