DESCRIPTION = "Tornado is an open source version of the scalable, non-blocking web server and tools that power FriendFeed."
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

PV = "4.5.3"

SRCREV = "8e9e75502ff910629663c4cdd7779d43ea2dd150"
SRC_URI = "git://github.com/tornadoweb/tornado.git;branch=branch4.5"

S = "${WORKDIR}/git"

inherit ${@bb.utils.contains("BBFILE_COLLECTIONS", "meta-python2", "setuptools", "", d)}

python() {
    if 'meta-python2' not in d.getVar('BBFILE_COLLECTIONS').split():
        raise bb.parse.SkipRecipe('Requires meta-python2 to be present.')
}

DEPENDS = "python-certifi"

RDEPENDS_${PN} = "python-certifi"
RDEPENDS_${PN} += "python-backports-abc"
RDEPENDS_${PN} += "python-singledispatch"

RCONFLICTS_${PN} = "python-tornado"
RCONFLICTS_${PN} += "python-tornado40"
RCONFLICTS_${PN} += "python-tornado50"

