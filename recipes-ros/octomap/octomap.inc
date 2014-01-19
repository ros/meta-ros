SRC_URI = "https://github.com/OctoMap/${ROS_SPN}/archive/v${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "ffbc6dd63a3c374fdce82ed124ece42b"
SRC_URI[sha256sum] = "a73fd0e7c77fa0bc5db6f654dd1bc2d6173c7bfe1b178c75edbf493527ee9682"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

EXTRA_OECMAKE += "\
  -DCMAKE_SKIP_RPATH=ON \
"

inherit cmake ros

ROS_SPN = "octomap"
