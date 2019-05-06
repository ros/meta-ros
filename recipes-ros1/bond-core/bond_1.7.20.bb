DESCRIPTION = "\
A bond allows two processes, A and B, to know when the other has \
terminated, either cleanly or by crashing. The bond remains \
connected until it is either broken explicitly or until a \
heartbeat times out.\
"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "message-generation std-msgs roscpp-serialization"

require bond-core.inc
