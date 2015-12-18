SRC_URI = "https://github.com/ros-drivers/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "1bf6135fae371901db1afea03186fa9a"
SRC_URI[sha256sum] = "7b0ee18352a251aea212a701881f59841741272cd9bb62970a32c726dd69d54f"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "audio_common"
