SRC_URI = "https://github.com/OctoMap/${ROS_SPN}/archive/v${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "d0742959d4b186ec2c21d61f8642708e"
SRC_URI[sha256sum] = "4e95c00f02e71458e5cf02f782e717cb00505d37413c240ee716de98f7bc30a0"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

EXTRA_OECMAKE += "\
  -DCMAKE_SKIP_RPATH=ON \
"

inherit cmake ros

ROS_SPN = "octomap"
