FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
# this patch is more or less yocto specific
SRC_URI:append = " \
    file://0001-CMakeLists.txt-relaxing-python-version-query.patch \
"

# because appearantly prebuild binaries are shipped :-[
INSANE_SKIP:${PN} += "already-stripped"