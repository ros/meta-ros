# Imported as-is from
# https://github.com/labgrid-project/meta-labgrid/commit/b3f7c1754740bd2a33fcf1d84f7374ab46242165

DESCRIPTION = "WebSocket client & server library, WAMP real-time framework"
HOMEPAGE = "http://crossbar.io/autobahn"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=97c0bda20ad1d845c6369c0e47a1cd98"

inherit pypi

RDEPENDS:${PN} = " \
    python3-twisted \
    python3-zopeinterface \
    python3-py-ubjson \
    python3-cbor \
    python3-u-msgpack-python \
    python3-lz4 \
    python3-snappy \
    python3-pyopenssl \
    python3-txaio \
    python3-six \
"
