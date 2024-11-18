
SUMMARY = "Meta package aggregating colcon-core and common extensions."
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://setup.cfg;beginline=22;endline=22;md5=3d0bd1ac53c1dd582844ed15eee7f8e2"

SRC_URI[sha256sum] = "84408d13f8a46044851a7a4e686749940539d2b3d02e6752746cbbc9a89049ff"

inherit pypi setuptools3

# Incomplete list from: https://github.com/colcon/colcon-common-extensions/blob/master/setup.cfg
# TODO: we might complete this once..
# - add: ${PYTHON_PN}-colcon-notification
RDEPENDS:${PN} += "\
    ${PYTHON_PN}-colcon-bash \
    ${PYTHON_PN}-colcon-cd \
    ${PYTHON_PN}-colcon-cmake \
    ${PYTHON_PN}-colcon-core \
    ${PYTHON_PN}-colcon-defaults \
    ${PYTHON_PN}-colcon-devtools \
    ${PYTHON_PN}-colcon-library-path \
    ${PYTHON_PN}-colcon-metadata \
    ${PYTHON_PN}-colcon-output \
    ${PYTHON_PN}-colcon-package-information \
    ${PYTHON_PN}-colcon-package-selection \
    ${PYTHON_PN}-colcon-parallel-executor \
    ${PYTHON_PN}-colcon-recursive-crawl \
    ${PYTHON_PN}-colcon-ros \
    ${PYTHON_PN}-colcon-test-result \
"

BBCLASSEXTEND += "nativesdk"
