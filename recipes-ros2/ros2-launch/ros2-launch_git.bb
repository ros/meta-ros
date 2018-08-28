SUMMARY = "The ROS launch tool."
HOMEPAGE = "https://github.com/ros2/launch"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

SRCREV = "499097a47e6474ebd7caf7a4b7dc4ad9c6004eee"
SRC_URI = "git://github.com/ros2/launch.git;protocol=git;"

S = "${WORKDIR}/git/launch"

inherit setuptools3
