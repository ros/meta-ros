DESCRIPTION = "matplotlib is a python 2D plotting library which produces publication quality figures in a variety of hardcopy formats"
SECTION = "devel/python"
LICENSE = "PSF"
LIC_FILES_CHKSUM = "file://LICENSE/LICENSE;md5=afec61498aa5f0c45936687da9a53d74"

DEPENDS += "python-numpy freetype libpng python-dateutil python-pytz"
RDEPENDS_${PN} = "python-core python-distutils python-numpy freetype libpng python-dateutil python-pytz"

SRCREV = "ebaff585e43b128055e9164ae5fce1efe8a01ef4"
ROS_BRANCH ?= "branch=master"
SRC_URI = " \
    git://github.com/matplotlib/matplotlib;${ROS_BRANCH};protocol=https \
    file://fix_setupext.patch \
"

S = "${WORKDIR}/git"

EXTRA_OECONF = "--disable-docs"

inherit pkgconfig

inherit ${@bb.utils.contains("BBFILE_COLLECTIONS", "meta-python2", "setuptools", "", d)}

python() {
    if 'meta-python2' not in d.getVar('BBFILE_COLLECTIONS').split():
        raise bb.parse.SkipRecipe('Requires meta-python2 to be present.')
}
