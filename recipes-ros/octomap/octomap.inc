SRC_URI = "https://github.com/OctoMap/${ROS_SPN}/archive/v${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "c53b4a57bd5dd3bb0c6da98be06bfb44"
SRC_URI[sha256sum] = "897d8dc8859cc1a43d1b505382dc2afcecd7310880282ef777d90498751b1d1b"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

EXTRA_OECMAKE += "\
  -DCMAKE_SKIP_RPATH=ON \
"

inherit cmake ros

ROS_SPN = "octomap"
