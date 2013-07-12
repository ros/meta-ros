SRC_URI = "https://github.com/ros/bond_core/archive/${PV}.tar.gz;downloadfilename=bond_core-${PV}.tar.gz"
SRC_URI[md5sum] = "1bb6c5dd1148c67d2759e665d7ae75b3"
SRC_URI[sha256sum] = "1145db3800591e585325131cb6322366e82e634c97dd3cbb4ab43e1c1f4ec415"

S = "${WORKDIR}/bond_core-${PV}/${PN}"

inherit catkin
