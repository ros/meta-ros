DESCRIPTION = "Messages used by the platform app manager."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=5ee5b8b046ae48ad94a2037ca953a67b"

DEPENDS = "message-generation rocon-std-msgs rocon-service-pair-msgs"

require rocon-msgs.inc

RDEPENDS_${PN} = "message-runtime"
