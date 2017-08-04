SUMMARY = "Generate the ROS interfaces in C++."
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

include rosidl.inc

RDEPENDS_${PN} += "rosidl-parser"
