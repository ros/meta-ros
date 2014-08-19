SRC_URI = "https://github.com/OctoMap/${ROS_SPN}/archive/v${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "6781c4a12958cca69570c334cf836f21"
SRC_URI[sha256sum] = "cad32744152970d0ab141d12c122d0482510644f29c61b8464bbfc65ebff1cf0"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

EXTRA_OECMAKE += "\
    -DCMAKE_SKIP_RPATH=ON \
"

inherit cmake ros

ROS_SPN = "octomap"
