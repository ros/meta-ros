DESCRIPTION = "ROS driver for RealSense camera"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=4bcd5f0e140091c68f8c0bcfdd6181e0"

DEPENDS = "librealsense cv-bridge camera-info-manager pcl-ros roscpp"
RDEPENDS_${PN} = "rgbd-launch"

SRC_URI = "https://github.com/intel-ros/realsense/archive/${PV}.tar.gz \
           file://0001-librealsense-Fix-link-when-the-system-library-is-use.patch \
           "
SRC_URI[md5sum] = "d2b6b4ef563e82acca28597e542b5049"
SRC_URI[sha256sum] = "18e2d3e847b3b1158c124b6167ea2751236a2749aca03532ca7d9f5b7b59e975"

S = "${WORKDIR}/realsense-${PV}/realsense_camera"

inherit catkin

EXTRA_OECMAKE = "-DUSE_SYSTEM_LIBREALSENSE:BOOL=ON"
