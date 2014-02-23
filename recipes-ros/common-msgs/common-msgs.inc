SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "465b593d618e2d80892da928b6adc7a8"
SRC_URI[sha256sum] = "1e20dc23e65268d9f4eacd3b16622bbed82db64063bf9cdd358d2b7d7f8be7cb"

DEPENDS += "cpp-common roscpp-serialization message-generation message-runtime std-msgs"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "common_msgs"
