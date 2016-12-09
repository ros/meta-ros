DESCRIPTION = "Cross-platform camera capture for Intel® RealSense™ F200, SR300 and R200"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI = "https://github.com/IntelRealSense/librealsense/archive/v${PV}.tar.gz \
           file://0001-Fix-detection-of-ROS-build.patch \
           "
SRC_URI[md5sum] = "27ce627c02731623c23894baeb73b2b1"

DEPENDS = "libusb1"

inherit catkin
