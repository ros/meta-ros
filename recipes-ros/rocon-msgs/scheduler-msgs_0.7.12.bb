DESCRIPTION = "Messages used by the rocon scheduler."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=5ee5b8b046ae48ad94a2037ca953a67b"

DEPENDS = "message-generation std-msgs rocon-std-msgs uuid-msgs"

require rocon-msgs.inc

RDEPENDS_${PN} = "message-runtime"
