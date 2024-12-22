
SUMMARY = "Command line tool to build sets of software packages."
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://setup.cfg;beginline=22;endline=22;md5=3d0bd1ac53c1dd582844ed15eee7f8e2"

SRC_URI = "file://0001-Remove-optional-pytest-dependencies.patch \
           file://0002-Force-shebang-to-usr-bin-env-python3.patch"
SRC_URI[sha256sum] = "8b3dcf0b140b2851a9169c60b3ed2ca78a6e48fec8ececdeefa287a6715f2e17"

inherit pypi setuptools3

# See: https://github.com/colcon/colcon-core/blob/master/setup.cfg
RDEPENDS:${PN} += "\
    ${PYTHON_PN}-coloredlogs \
    ${PYTHON_PN}-distlib \
    ${PYTHON_PN}-empy \
    ${PYTHON_PN}-packaging \
"

# The pytest dependencies are optional:
# ${PYTHON_PN}-pytest
# ${PYTHON_PN}-pytest-cov
# ${PYTHON_PN}-pytest-repeat
# ${PYTHON_PN}-pytest-rerunfailures

BBCLASSEXTEND = "native nativesdk"
