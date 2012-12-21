DESCRIPTION = "VCS/SCM source control library for svn, git, hg, and bzr"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=c9c3f6ca5564e5a9b38751ea86bdc0bb"
SRCNAME = "vcstools"

SRC_URI = "http://pr.willowgarage.com/downloads/vcstools/vcstools-${PV}.tar.gz"
SRC_URI[md5sum] = "ca37f2de93c303796a46a946f94ad11c"
SRC_URI[sha256sum] = "11cae4907609d3524655c7cdba66260821f69fd2ff2330ae93db35111c70efbd"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

