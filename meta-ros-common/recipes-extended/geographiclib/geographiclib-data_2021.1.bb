# Load geographiclib data sets required by mavros
# TODO: might be better to attach to mavros??

# Rationale:
# The mavros script '/usr/lib/mavros/install_geographiclib_datasets.sh' calls
# bash scripts from geographiclib, which calls wget a couple of times.
# We use here bitbake as a fetcher for these data files.

# Mavros selects these files:
# geoids egm96-5
# gravity egm96
# magnetic emm2015

SUMMARY = "Data files for geographiclib."
SECTION = "devel"
# TODO: Check license of data files??
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

SRC_URI = " \
    https://downloads.sourceforge.net/project/geographiclib/geoids-distrib/egm96-5.tar.bz2?use_mirror=autoselect;name=geoids;downloadfilename=egm96-5.tar.bz2 \
    https://downloads.sourceforge.net/project/geographiclib/gravity-distrib/egm96.tar.bz2?use_mirror=autoselect;name=gravity;downloadfilename=egm96.tar.bz2 \
    https://downloads.sourceforge.net/project/geographiclib/magnetic-distrib/emm2015.tar.bz2?use_mirror=autoselect;name=magnetic;downloadfilename=emm2015.tar.bz2 \
"

SRC_URI[geoids.md5sum] = "6ae1c02c0506a686c9ad33be42cad0ae"
SRC_URI[geoids.sha256sum] = "c46224f8f723dc915d97179f4e1580a98d6c742fe2b82cd8fef0ecaaad13e614"
SRC_URI[gravity.md5sum] = "dcc1ab8e3433bd0add901b2f3e5caa76"
SRC_URI[gravity.sha256sum] = "6fea4c6bd56ff8ac53dbdad8d5dd505c855471d0354c4abc5c5fe048bf8350c1"
SRC_URI[magnetic.md5sum] = "18065cd3cc7369293d2a43c0c8f45315"
SRC_URI[magnetic.sha256sum] = "8e71a9704c5f2714bb65581df68e30f0d84d0ad17286d00efb782e7232334c3f"

do_install() {
    install -d -m 0755 ${D}/${datadir}/GeographicLib/geoids
    install -d -m 0755 ${D}/${datadir}/GeographicLib/gravity
    install -d -m 0755 ${D}/${datadir}/GeographicLib/magnetic
    install -D -m 0644 ${WORKDIR}/geoids/* ${D}/${datadir}/GeographicLib/geoids
    install -D -m 0644 ${WORKDIR}/gravity/* ${D}/${datadir}/GeographicLib/gravity
    install -D -m 0644 ${WORKDIR}/magnetic/* ${D}/${datadir}/GeographicLib/magnetic
}

FILES:${PN} = " \
    ${datadir}/GeographicLib \
"
