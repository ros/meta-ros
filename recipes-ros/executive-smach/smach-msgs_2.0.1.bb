DESCRIPTION = "this package contains a set of messages that are used by the introspection interfaces for smach."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "message-generation std-msgs roscpp-serialization"

RDEPENDS_${PN} = "message-runtime"

require executive-smach.inc
