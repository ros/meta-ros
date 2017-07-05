DESCRIPTION = "Utilities for gateway users (avoids large dependency requirements)."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

require rocon-multimaster.inc

RDEPENDS_${PN} = "rosgraph gateway-msgs rocon-console rocon-python-comms rosservice"
