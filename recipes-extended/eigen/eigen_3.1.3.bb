require eigen.inc

PR = "r0"

SRC_URI += "file://eigen-disable-tests.patch"

SRC_URI[md5sum] = "43eee0e9252a77149d6b65e93e73b79d"
SRC_URI[sha256sum] = "1a443145f321dd47a5ca11f176e7319056198a6124a7577723d92e3c3cd59ece"

S = "${WORKDIR}/eigen-eigen-2249f9c22fe8"
