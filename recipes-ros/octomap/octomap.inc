SRC_URI = "https://github.com/OctoMap/${ROS_SPN}/archive/v${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "b4ea2f354e286c48263543dac42cf555"
SRC_URI[sha256sum] = "c68b75913ea5ebeb5459eaf2114801477aeaa2a584b018b8816f8a510150e76e"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit cmake ros

ROS_SPN = "octomap"
