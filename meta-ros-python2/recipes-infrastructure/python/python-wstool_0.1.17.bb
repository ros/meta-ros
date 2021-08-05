DESCRIPTION = "workspace multi-SCM commands"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=e910b35b0ef4e1f665b9a75d6afb7709"
SRCNAME = "wstool"

SRC_URI = "http://download.ros.org/downloads/wstool/wstool-${PV}.tar.gz"
SRC_URI[md5sum] = "656e6456e31dc5a43f0a9aae9efed7ea"
SRC_URI[sha256sum] = "c79b4f110ef17004c24972d742d2c5f606b0f6b424295e7ed029a48e857de237"

S = "${WORKDIR}/${SRCNAME}-${PV}"

RDEPENDS:${PN} += "python-vcstools python-pyyaml python-rosinstall"

inherit ${@bb.utils.contains("BBFILE_COLLECTIONS", "meta-python2", "setuptools", "", d)}

python() {
    if 'meta-python2' not in d.getVar('BBFILE_COLLECTIONS').split():
        raise bb.parse.SkipRecipe('Requires meta-python2 to be present.')
}

FILES:${PN} += "${datadir}/zsh"
