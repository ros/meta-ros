DESCRIPTION = "Python Timezone Library"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=22b38951eb857cf285a4560a914b7cd6"

SRC_URI = "https://pypi.python.org/packages/source/p/pytz/pytz-${PV}.tar.gz;downloadfilename=pytz-{PV}.tar.gz"
SRC_URI[md5sum] = "ff047a16dafeaa895bedef80a74c3728"
SRC_URI[sha256sum] = "c598a6b6850dbcc00843651878e8282dac77c95e19d84847b6918eeb3ed8f0c2"

S = "${WORKDIR}/pytz-${PV}"

inherit setuptools
