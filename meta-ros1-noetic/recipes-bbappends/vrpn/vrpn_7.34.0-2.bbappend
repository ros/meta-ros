# Copyright (c) 2021 LG Electronics, Inc.

# ERROR: vrpn-7.34.0-1-r0 do_package: QA Issue: vrpn: Files/directories were installed but not shipped in any package:
#  /usr/etc
#  /usr/etc/vrpn.cfg
# ...
do_install:append () {
    if [ -d ${D}${prefix}${sysconfdir} ] ; then
        mv ${D}${prefix}${sysconfdir} ${D}${sysconfdir}
    fi
}

# ERROR: vrpn-7.34.0-1-r0 do_package: QA Issue: vrpn: Files/directories were installed but not shipped in any package:
#  /usr/etc
#  /usr/etc/vrpn.cfg
#  /usr/share/quatlib
#  /usr/share/quatlib/cmake
#  /usr/share/quatlib/cmake/quatlibConfig.cmake
#  /usr/share/vrpn-07.34
#  /usr/share/vrpn-07.34/vrpn.cfg.sample
FILES:${PN} += " \
    ${datadir}/quatlib \
    ${datadir}/vrpn-07.34 \
"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-python-CMakeLists.txt-fix-matching-for-python-3.10.patch"
