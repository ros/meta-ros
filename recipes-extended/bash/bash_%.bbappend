# Copyright (c) 2019 LG Electronics, Inc.

# Provide the real BASH as /bin/bash-real in a package named "bash-real". Components that require it then add "bash-real" to their
# RDEPENDS to pull it in.

FILES_${PN}-real_class-target = "${base_bindir}/bash-real"
PACKAGE_BEFORE_PN_prepend_class-target = "${PN}-real "

PROVIDES_class-target = "${PN}-real"
RPROVIDES_${PN}-real_class-target = "bash-real"

do_install_append_class-target () {
    cp ${D}${base_bindir}/bash ${D}${base_bindir}/bash-real
}
