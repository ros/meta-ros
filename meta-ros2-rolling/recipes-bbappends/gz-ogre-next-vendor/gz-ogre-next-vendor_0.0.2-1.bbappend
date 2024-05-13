FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://use-system-ogre-next.patch"

DEPENDS += "ogre-next"
