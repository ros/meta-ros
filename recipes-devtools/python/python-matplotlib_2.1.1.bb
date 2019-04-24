DESCRIPTION = "matplotlib is a python 2D plotting library which produces publication quality figures in a variety of hardcopy formats"
SECTION = "devel/python"
LICENSE = "PSF"
LIC_FILES_CHKSUM = "file://LICENSE/LICENSE;md5=afec61498aa5f0c45936687da9a53d74"

DEPENDS += "python-numpy freetype libpng python-dateutil python-pytz"
RDEPENDS_${PN} = "python-core python-distutils python-numpy freetype libpng python-dateutil python-pytz"

SRC_URI = "https://github.com/matplotlib/matplotlib/archive/v${PV}.tar.gz;downloadfilename=${BP}.tar.gz \
           file://fix_setupext.patch \
"
SRC_URI[md5sum] = "495773801b8ae731d382284dcf87cbc6"
SRC_URI[sha256sum] = "40830d614384f0d837c81f1ca3cef795cfb871cb1d49cde0fc5beea157cec372"
S = "${WORKDIR}/matplotlib-${PV}"
EXTRA_OECONF = "--disable-docs"

inherit setuptools pkgconfig

