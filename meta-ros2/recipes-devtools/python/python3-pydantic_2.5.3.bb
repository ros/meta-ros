SUMMARY = "Data validation using Python type hints"
HOMEPAGE = "https://github.com/pydantic/pydantic"
DESCRIPTION = "Data validation using Python type hints."
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=09280955509d1c4ca14bae02f21d49a6"

SRC_URI[sha256sum] = "b3ef57c62535b0941697cce638c08900d87fcb67e29cfa99e8a68f747f393f7a"

inherit pypi python_hatchling

S = "${WORKDIR}/pydantic-2.5.3"

DEPENDS += " \
    python3-hatch-fancy-pypi-readme-native \
"

BBCLASSEXTEND = "native nativesdk"
