SRC_URI = "https://github.com/orocos/${SPN}/archive/v${PV}.tar.gz;downloadfilename=${SPN}-${PV}.tar.gz"
SRC_URI[md5sum] = "dc927de422cf6afe716ec7b12c0eed11"
SRC_URI[sha256sum] = "7be2dd5e4f4c1ceac2cdf1f4fae3d94d4ffd9fc1af8d483c05f04e80ef84b3f9"

S = "${WORKDIR}/${SPN}-${PV}/${@d.getVar('BPN', True).replace('-', '_')}"

inherit cmake

SPN = "orocos_kinematics_dynamics"
