SUMMARY = "Data validation using Python type hints"
HOMEPAGE = "https://github.com/pydantic/pydantic"
DESCRIPTION = "Data validation using Python type hints."
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=09280955509d1c4ca14bae02f21d49a6"

SRC_URI[sha256sum] = "b3ef57c62535b0941697cce638c08900d87fcb67e29cfa99e8a68f747f393f7a"

# SRC_URI = "git://github.com/pydantic/pydantic.git;protocol=https;branch=main"
# SRCREV = "9f58e785a5f1f2c34437f6e9b6adcd5b969e0df4"

inherit pypi
inherit setuptools3

S = "${WORKDIR}/pydantic-2.5.3"

do_configure:prepend() {
cat > ${S}/setup.py <<-EOF
from setuptools import setup

setup(
       name="${PYPI_PACKAGE}",
       version="${PV}",
       license="${LICENSE}",
)
EOF
}

BBCLASSEXTEND = "native nativesdk"
