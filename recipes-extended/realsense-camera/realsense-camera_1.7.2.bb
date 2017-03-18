DESCRIPTION = "ROS driver for RealSense camera"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=4bcd5f0e140091c68f8c0bcfdd6181e0"

DEPENDS = "librealsense cv-bridge camera-info-manager pcl-ros roscpp"

SRC_URI = "https://github.com/intel-ros/realsense/archive/${PV}.tar.gz \
           file://0001-Add-option-to-link-against-non-catkin-librealsense.patch \
           file://0002-Enable-roslint-when-CATKIN_ENABLE_TESTING-is-True.patch \
           "
SRC_URI[md5sum] = "aaa0d0ddaaee210e2a2529767ba45a4b"
SRC_URI[sha256sum] = "65c6c4a0b6bd0214dffa8528033f03c0fbc4be00e52e058cfbd96b4f7d733b10"

S = "${WORKDIR}/realsense-${PV}/realsense_camera"

inherit catkin

EXTRA_OECMAKE = "-DUSE_SYSTEM_LIBREALSENSE:BOOL=ON"
