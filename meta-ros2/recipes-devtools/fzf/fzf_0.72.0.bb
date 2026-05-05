SUMMARY = "A command-line fuzzy finder"
HOMEPAGE = "https://github.com/junegunn/fzf.git"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://src/${GO_IMPORT}/LICENSE;md5=edd55e9a395baee52799d6fb23fef6e5 \
                    file://src/${GO_IMPORT}/src/LICENSE;md5=edd55e9a395baee52799d6fb23fef6e5 \
                    "

SRC_URI = "git://${GO_IMPORT};protocol=https;nobranch=1;destsuffix=${GO_SRCURI_DESTSUFFIX}"
SRCREV = "6fefe025461b168eac2546ccba3403b70eb5da16"

require ${BPN}-licenses.inc
require ${BPN}-go-mods.inc
GO_IMPORT = "github.com/junegunn/fzf"

inherit go-mod go-mod-update-modules

BBCLASSEXTEND = "native nativesdk"
