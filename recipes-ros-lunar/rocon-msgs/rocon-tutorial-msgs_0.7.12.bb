DESCRIPTION = "Messages used by rocon tutorials."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=5ee5b8b046ae48ad94a2037ca953a67b"

DEPENDS = "message-generation rocon-service-pair-msgs"

require rocon-msgs.inc

RDEPENDS_${PN} = "message-runtime"
