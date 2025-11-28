# Copyright (c) 2019 LG Electronics, Inc.

LICENSE = "BSD-3-Clause"

do_install:append() {
    rm -rf ${D}${prefix}/src
}
