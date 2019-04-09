SRC_URI = "https://github.com/ros-drivers/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${PV}.tar.gz"
SRC_URI[md5sum] = "7ba576af37797b06147bbe951a3ff08f"
SRC_URI[sha256sum] = "35e98096491d3c5d2a9e10a22536647b1da86b96445fe70c4ccfc931c2789b60"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "velodyne"
