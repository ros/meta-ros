SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "1c008e362a2b9eee5b5a57e46452b9cf"
SRC_URI[sha256sum] = "44b6455ebc6406b9d2ced5efe590bcbf22cf3fe3107d363409d0262aaa21ebb9"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "bond_core"
