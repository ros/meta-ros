# Copyright (c) 2021 LG Electronics, Inc.

# ERROR: iceoryx-posh-0.99.7-1-r0 do_package: QA Issue: iceoryx-posh: Files/directories were installed but not shipped in any package:
#  /usr/etc
#  /usr/etc/roudi_config_example.toml
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# iceoryx-posh: 2 installed and not shipped files. [installed-vs-shipped]
do_install:append () {
    if [ -d ${D}${prefix}${sysconfdir} ] ; then
        mv ${D}${prefix}${sysconfdir} ${D}${sysconfdir}
    fi
}

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
    file://0001-Fix-build-with-gcc-11.patch;patchdir=cpptoml-upstream \
    file://0001-cpptoml-fetch-with-bitbake-fetcher-instead-of-Extern.patch \
    file://0001-Revert-iox-713-document-the-restrictions-on-size-and.patch \
    file://0002-Revert-iox-14-add-member-to-ChunkHeader-reduce-its-a.patch \
    file://0001-IceoryxPoshDeployment.cmake-change-DESTINATION_CONFIG.patch \
"
