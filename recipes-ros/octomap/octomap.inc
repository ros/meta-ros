SRC_URI = "https://github.com/OctoMap/${ROS_SPN}/archive/v${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "e4f9ab54fecfc031ec160b8989340804"
SRC_URI[sha256sum] = "833adba0d3b203cab0e28a0180490e74bc852a7fea9adf6ee53bbfb8f10bc79a"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

EXTRA_OECMAKE += "\
    -DCMAKE_SKIP_RPATH=ON \
"

inherit cmake ros

ROS_SPN = "octomap"
