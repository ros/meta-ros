SRC_URI = "https://github.com/stonier/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "b0212776e9c4ae69800a0a4a06e0ad25"
SRC_URI[sha256sum] = "37c1a7febd79ce67cf03f6bbf69dd839ca1efe576b46f22ff6a4ca66e7f8a791"

SRC_URI += "file://0001-address-gcc6-build-error.patch;patchdir=.."

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "zeroconf_avahi_suite"
