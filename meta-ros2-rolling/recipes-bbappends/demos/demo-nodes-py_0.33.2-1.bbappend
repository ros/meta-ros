# Copyright (c) 2023 Wind River Systems, Inc.

do_install:append() {
    mv ${D}${bindir}/listener ${D}${bindir}/${PN}-listener
    mv ${D}${bindir}/talker ${D}${bindir}/${PN}-talker
}
