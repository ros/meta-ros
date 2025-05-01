# ERROR: QA Issue: ecl-license: Files/directories were installed but not shipped in any package:
#  /usr/share/licenses
#  /usr/share/licenses/COPYING
#  /usr/share/licenses/AUTHORS
#  /usr/share/licenses/COPYING-PLAIN
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# ecl-license: 4 installed and not shipped files. [installed-vs-shipped]

# To fix this: If we are not caring for the license package, discard (delete)
# the files. If we are creating a -lic package, move it to the right
# location.

do_install:append () {
    if [ "${LICENSE_CREATE_PACKAGE}" == "0" ]; then
        rm ${D}/usr/share/licenses -Rf
    else
        install -m 755 -d ${D}${datadir}/licenses/${PN}        
        mv ${D}${datadir}/licenses/*  ${D}${datadir}/licenses/${PN}/
    fi
}

## overwriting "BSD" to proper SPDX 
LICENSE = "BSD-3-Clause"
