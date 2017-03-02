DESCRIPTION = "XML bomb protection for Python stdlib modules"
SECTION = "devel/python"
LICENSE = "PSFL"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=a560e172e996ab553d352ccff41c7d20"
SRCNAME = "defusedxml"

SRC_URI = "http://pypi.python.org/packages/source/d/defusedxml/defusedxml-${PV}.tar.gz"
SRC_URI[md5sum] = "230a5eff64f878b392478e30376d673a"
SRC_URI[sha256sum] = "cd551d5a518b745407635bb85116eb813818ecaf182e773c35b36239fc3f2478"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
