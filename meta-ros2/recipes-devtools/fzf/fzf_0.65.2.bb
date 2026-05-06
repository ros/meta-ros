SUMMARY = "A command-line fuzzy finder"
HOMEPAGE = "https://github.com/junegunn/fzf.git"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://src/${GO_IMPORT}/LICENSE;md5=4e11c26cb155f78c5467051a82533faa \
                    file://src/${GO_IMPORT}/src/LICENSE;md5=4e11c26cb155f78c5467051a82533faa \
                    "

SRC_URI = "git://${GO_IMPORT};destsuffix=git/src/${GO_IMPORT};nobranch=1;name=${BPN};protocol=https \
           file://modules.txt \
           "

# tag v0.65.2
SRCREV = "1afd14381079a35eac0a4c2a5cacb86e2a3f476b"

S = "${WORKDIR}/git"

LICENSE += " & ${GO_MOD_LICENSES}"
require fzf-licenses.inc
require fzf-modules.inc
GO_IMPORT = "github.com/junegunn/fzf"
SRCREV_FORMAT = "${BPN}"

inherit go-vendor

BBCLASSEXTEND = "native nativesdk"
