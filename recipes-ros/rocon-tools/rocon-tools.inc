SRC_URI = "https://github.com/robotics-in-concert/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "32191c042411a5af1dd584453a57cf78"
SRC_URI[sha256sum] = "14f8b3d42a343fd1ef7be4e9756fc47b1bb2714f2068f8509e6f51086945a356"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "rocon_tools"
