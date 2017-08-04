SUMMARY = "The decision which ROS middleware implementation should be used for C++."
HOMEPAGE = "https://github.com/ros2/example_interfaces"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

DEPENDS = " \
    rcutils \
    rmw \
    rmw-implementation-cmake \
    rmw-fastrtps-cpp \
    poco \
"

SRCREV = "2c75b061917def24592ae195368689187a550984"
SRC_URI = "git://github.com/ros2/rmw_implementation.git;protocol=git; \
           file://0001-get-rid-of-poco-vendor-dependency.patch;patchdir=.. \
           "

inherit ament
