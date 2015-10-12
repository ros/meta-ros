DESCRIPTION = "Python Timezone Library"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=5c41ec3eb91b0520c393ae015d5f8fa1"

DEPENDS = ""


SRC_URI = "https://pypi.python.org/packages/source/p/pytz/pytz-${PV}.tar.gz;downloadfilename=pytz-{PV}.tar.gz"
SRC_URI[md5sum] = "ff047a16dafeaa895bedef80a74c3728"
SRC_URI[sha256sum] = "b84569685426374242dfc7d4fa08c9694951e85203d085c256866cf87dcb0b7e"

S = "${WORKDIR}/pytz-${PV}"

inherit setuptools

ROS_SPN = "pytz"
