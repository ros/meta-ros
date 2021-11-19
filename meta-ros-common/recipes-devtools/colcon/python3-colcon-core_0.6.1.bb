
SUMMARY = "Command line tool to build sets of software packages."
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://setup.cfg;beginline=22;endline=22;md5=3d0bd1ac53c1dd582844ed15eee7f8e2"

SRC_URI += "file://0001-Remove-optional-pytest-dependencies.patch \
           file://0002-Fix-regression-when-enitre-workspace-is-symlinked.patch \
           "
SRC_URI[sha256sum] = "fc14534b2ce745fcc332afc0bb0ddf3e45d5d69c15da15b9471cfb7b0b9edbe9"

inherit pypi setuptools3

# See: https://github.com/colcon/colcon-core/blob/master/setup.cfg
RDEPENDS:${PN} += "\
    ${PYTHON_PN}-coloredlogs \
    ${PYTHON_PN}-distlib \
    ${PYTHON_PN}-empy \
"

# The pytest dependencies are optional:
# ${PYTHON_PN}-pytest
# ${PYTHON_PN}-pytest-cov
# ${PYTHON_PN}-pytest-repeat
# ${PYTHON_PN}-pytest-rerunfailures

BBCLASSEXTEND = "native nativesdk"
