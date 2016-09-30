SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "d727bc9da9f7772649ab7c5c7c9f652e"
SRC_URI[sha256sum] = "fc3073428fc930523efd6ed4a86d838ab0f0ff04a312eb4188c72a854d300e97"

SRC_URI += "file://0001-address-gcc6-build-error.patch;patchdir=.."
SRC_URI += "file://0002-explicitly-cast-to-std-vector-double-to-make-gcc6-ha.patch;patchdir=.."

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "image_pipeline"
