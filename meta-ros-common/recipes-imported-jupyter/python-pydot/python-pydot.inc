SUMMARY = "Python interface to Graphviz's Dot"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f5ce36373e1542c5b82d521315da8cc2"

SRC_URI[sha256sum] = "d49c9d4dd1913beec2a997f831543c8cbd53e535b1a739e921642fe416235f01"

RDEPENDS_${PN} += " \
    ${PYTHON_PN}-pyparsing \
    graphviz \
"
