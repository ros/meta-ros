SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "72dc5897c021987cca04756cbf3ddc27"
SRC_URI[sha256sum] = "022f3c81ade13e644cf7f3c96712a362dc668f2edf37c125f3b9411818eb294a"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "image_common"
