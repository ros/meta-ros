DESCRIPTION = "Client api for discovery and connection to rocon hubs."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

require rocon-multimaster.inc

RDEPENDS_${PN} = "gateway-msgs rospy rocon-python-redis rocon-gateway-utils"
