DESCRIPTION = "Messages used by workflow engine"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=5ee5b8b046ae48ad94a2037ca953a67b"

DEPENDS = "message-generation std-msgs"

require rocon-msgs.inc

RDEPENDS_${PN} = "message-runtime"
