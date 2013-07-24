SRC_URI = "https://github.com/ros-perception/image_common/archive/${PV}.tar.gz;downloadfilename=image_common-${PV}.tar.gz"
SRC_URI[md5sum] = "72dc5897c021987cca04756cbf3ddc27"
SRC_URI[sha256sum] = "022f3c81ade13e644cf7f3c96712a362dc668f2edf37c125f3b9411818eb294a"

inherit catkin

S = "${WORKDIR}/image_common-${PV}/${ROS_BPN}"
