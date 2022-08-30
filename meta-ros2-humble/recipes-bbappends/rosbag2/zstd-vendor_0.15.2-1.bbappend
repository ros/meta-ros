EXTRA_OECMAKE:append = " \
    -Dzstd_ROOT_DIR=${STAGING_DIR_TARGET}/usr \
"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
# Patch upstream pending
SRC_URI:append = " \
    file://0001-Fix-zstd-vendor-does-not-find-system-zstd-1111.patch \
"