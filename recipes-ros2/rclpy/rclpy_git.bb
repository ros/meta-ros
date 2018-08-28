SUMMARY = "Package containing the Python client."
HOMEPAGE = "https://github.com/ros2/rclpy"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=12c26a18c7f493fdc7e8a93b16b7c04f"
DEPENDS = " \
        python-cmake-module \
        rcl \
"

SRCREV = "6b217daf62f4be6b679d3b8a4946aaafff5dc2be"
SRC_URI = "git://github.com/ros2/rclpy.git;protocol=git;"

inherit ament
