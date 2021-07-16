# Copyright (c) 2019 LG Electronics, Inc.

# Provide the real BASH as /bin/bash-real in a package named "bash-real". Components that require it then add "bash-real" to their
# RDEPENDS to pull it in.

FILES:${PN}-real:class-target = "${base_bindir}/bash-real"
PACKAGE_BEFORE_PN:prepend:class-target = "${PN}-real "

PROVIDES:class-target = "${PN}-real"
RPROVIDES:${PN}-real:class-target = "bash-real"

do_install:append:class-target () {
    cp ${D}${base_bindir}/bash ${D}${base_bindir}/bash-real
}
