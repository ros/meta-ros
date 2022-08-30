# This is needed so iceoryx-posh will find the cmake files provided by
# iceoryx-hoofs.
EXTRA_OECMAKE:append = "-DCMAKE_MODULE_PATH=${STAGING_DIR_TARGET}/usr/lib/cmake/iceoryx_hoofs/"

# removing unneeded example, fixing installed-vs-shipped QA
do_install:append() {
    rm ${D}/usr/etc/roudi_config_example.toml
    rm -R ${D}/usr/etc
}

# The rest is taken from original bbappend from LG

# iceoryx-binding-c/0.99.7-1-r0/recipe-sysroot/usr/lib/cmake/iceoryx_posh/iceoryx_poshTargets.cmake:109 (message):
# expects the binary to exist:
# The imported target "iceoryx_posh::iox-roudi" references the file
# "TOPDIR/tmp-glibc/work/qemux86-webos-linux/iceoryx-binding-c/0.99.7-1-r0/recipe-sysroot/usr/bin/iox-roudi"
# OE doesn't stage ${bindir} for target recipes, but in this case the iceoryx_posh::iox-roudi isn't
# being called during the cross-build, so we can include it just to keep CMake happy
sysroot_stage_all:append() {
    sysroot_stage_dir ${D}${bindir} ${SYSROOT_DESTDIR}${bindir}
}

# v0.1.1 tag
SRCREV_cpptoml = "0bfa56fc8361e1715de05709b349bc44d910c7db"
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "git://github.com/skystrife/cpptoml.git;name=cpptoml;destsuffix=git/cpptoml-upstream;branch=master;protocol=https \
    file://0001-cpptoml-fetch-with-bitbake-fetcher-instead-of-Extern.patch \
"