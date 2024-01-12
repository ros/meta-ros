SUMMARY = "Fast implementation of asyncio event loop on top of libuv"
HOMEPAGE = "https://github.com/MagicStack/uvloop"
DESCRIPTION = "Fast implementation of asyncio event loop on top of libuv"
SECTION = "devel/python"
LICENSE = "Apache-2.0 & MIT"
LIC_FILES_CHKSUM = "file://LICENSE-APACHE;md5=bb92739ddad0a2811957bd98bdb90474 \
                    file://LICENSE-MIT;md5=489c8bc34154e4b59f5c58e664f7d70f"

SRC_URI[sha256sum] = "0246f4fd1bf2bf702e06b0d45ee91677ee5c31242f39aab4ea6fe0c51aedd0fd"

inherit pypi
inherit setuptools3

S = "${WORKDIR}/uvloop-${PV}"

# RDEPENDS:${PN} += " \
#     python3-asyncio \
#     python3-core \
#     python3-ctypes \
#     python3-io \
#     python3-logging \
#     python3-math \
#     python3-multiprocessing \
#     python3-netclient \
#     python3-numbers \
#     python3-pickle \
#     python3-pprint \
#     python3-psutil \
#     python3-threading \
#     python3-unittest \
# "
# 
# WARNING: We were unable to map the following python package/module
# dependencies to the bitbake packages which include them:
#    OpenSSL
#    aiohttp
#    aiohttp.web
#    flake8
#    mypy

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
