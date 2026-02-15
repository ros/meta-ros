
SUMMARY = "Meta package aggregating colcon-core and common extensions."
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://setup.cfg;beginline=22;endline=22;md5=3d0bd1ac53c1dd582844ed15eee7f8e2"

SRC_URI[sha256sum] = "84408d13f8a46044851a7a4e686749940539d2b3d02e6752746cbbc9a89049ff"

inherit pypi setuptools3

# Incomplete list from: https://github.com/colcon/colcon-common-extensions/blob/master/setup.cfg
# TODO: we might complete this once..
# - add: python3-colcon-notification
RDEPENDS:${PN} += "\
    python3-colcon-bash \
    python3-colcon-cd \
    python3-colcon-cmake \
    python3-colcon-core \
    python3-colcon-defaults \
    python3-colcon-devtools \
    python3-colcon-library-path \
    python3-colcon-metadata \
    python3-colcon-output \
    python3-colcon-package-information \
    python3-colcon-package-selection \
    python3-colcon-parallel-executor \
    python3-colcon-recursive-crawl \
    python3-colcon-ros \
    python3-colcon-test-result \
"

BBCLASSEXTEND += "nativesdk"
