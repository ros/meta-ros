DESCRIPTION = "ROS driver for RealSense camera"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=4bcd5f0e140091c68f8c0bcfdd6181e0"

DEPENDS = "librealsense cv-bridge camera-info-manager pcl-ros roscpp"

SRC_URI = "https://github.com/intel-ros/realsense/archive/${PV}.tar.gz \
           file://0001-realsense-camera-don-t-ignore-linker-flags-set-by-us.patch \
           "
SRC_URI[md5sum] = "4adab9a45a0b7a84cd28f1de538d0de8"

S = "${WORKDIR}/realsense-${PV}/realsense_camera"

inherit catkin
