DESCRIPTION = "XML bomb protection for Python stdlib modules"
SECTION = "devel/python"
LICENSE = "Python-2.0"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=a560e172e996ab553d352ccff41c7d20"
PYPI_PACKAGE = "defusedxml"

SRC_URI[sha256sum] = "24d7f2f94f7f3cb6061acb215685e5125fbcdc40a857eff9de22518820b0a4f4"

inherit pypi

BBCLASSEXTEND += "native"
