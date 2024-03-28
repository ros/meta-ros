# Copyright (c) 2023 Wind River Systems, Inc.

do_install:append() {
    mv ${D}${bindir}/client ${D}${bindir}/${PN}-client
}
