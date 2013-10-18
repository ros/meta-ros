DESCRIPTION="Metapackage for core of rosserial."
SRC_URI = "https://github.com/ros-drivers/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${PV}.tar.gz"
SRC_URI[md5sum] = "0a6191b2c5ecf9de527a9365299c59b2"
SRC_URI[sha256sum] = "b00fa3871f204e300dcd16a8847f3a81d64f57bb2ae96b3f3c41f77945e923be"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "rosserial"
