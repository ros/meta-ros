SRC_URI = "https://github.com/ros/roscpp_core/archive/${PV}.tar.gz;downloadfilename=rosscpp_core-${PV}.tar.gz"
SRC_URI[md5sum] = "d02c9d1270d1f68487944fb0e76adcb7"
SRC_URI[sha256sum] = "805b08c5b7044dd93bfaf4a0dd5807b391d1d86db9f6d143f9946b5528500eda"

S = "${WORKDIR}/roscpp_core-${PV}/${BPN}"

inherit catkin
