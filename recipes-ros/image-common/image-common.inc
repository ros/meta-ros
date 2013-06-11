SRC_URI = "https://github.com/ros-perception/image_common/archive/${PV}.tar.gz;downloadfilename=image_common-${PV}.tar.gz"
SRC_URI[md5sum] = "1831f995e72eeeb143b0d3f072a2c153"
SRC_URI[sha256sum] = "e111bb72da8df67efb742c05742d774a337266e0b2a70073e283c157b4ab7029"

inherit catkin

S = "${WORKDIR}/image_common-${PV}/${ROS_BPN}"
