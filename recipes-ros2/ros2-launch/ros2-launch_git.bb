SUMMARY = "The ROS launch tool."
HOMEPAGE = "https://github.com/ros2/launch"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

SRCREV = "90181d102362028eb88f225f2b3377f51dc74526"
SRC_URI = "git://github.com/ros2/launch.git;protocol=git;"

S = "${WORKDIR}/git/launch"

RDEPENDS_${PN} += "${PYTHON_PN}-asyncio"

inherit setuptools3
