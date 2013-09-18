DESCRIPTION = "Transmission Interface."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=68b329da9893e34099c7d8ad5cb9c940"

DEPENDS = "hardware-interface cmake-modules libtinyxml"

require ros-control.inc

SRC_URI += "file://0001-transmission-interface-fix2.patch;striplevel=2;name=patch"
SRC_URI[patch.md5sum] = "652e61a240baa2954c789fedc285654c"
SRC_URI[patch.sha256sum] = "2b0268d19ab708b4ec2e897017edd2b2a03c2a336b916e0cee5248e390627ab1"


SRC_URI += "file://0001-transmission-interface-comment-gtests.patch;striplevel=2;name=patch2"
SRC_URI[patch2.md5sum] = "60e27aa262486ba0f8161f8ea7e561e7"
SRC_URI[patch2.sha256sum] = "f99dac95eccc3ae209a3a35cfab0baa13843933fb8833845b4e067cf58828675"

