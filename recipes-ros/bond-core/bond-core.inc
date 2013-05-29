SRC_URI = "https://github.com/ros/bond_core/archive/${PV}.tar.gz;downloadfilename=bond_core-${PV}.tar.gz"
SRC_URI[md5sum] = "ce18d722353318f1a6e360a271529abb"
SRC_URI[sha256sum] = "4fc2019acc136768dafc3e7422dac622cc58038aaf8a41302e45cc9510c1c723"

S = "${WORKDIR}/bond_core-${PV}/${PN}"

inherit catkin
