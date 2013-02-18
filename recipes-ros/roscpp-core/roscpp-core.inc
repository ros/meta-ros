SRC_URI = "https://github.com/ros/roscpp_core/archive/${PV}.tar.gz;downloadfilename=rosscpp_core-${PV}.tar.gz"
SRC_URI[md5sum] = "ddbed4b9c97e406ecf104915eb31319c"
SRC_URI[sha256sum] = "662595304df7ba932906aa30774dfd4c3074cc4b7773620fc80de2d724769ef8"

S = "${WORKDIR}/roscpp_core-${PV}/${BPN}"

inherit catkin
