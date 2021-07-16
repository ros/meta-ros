# Copyright (c) 2019 LG Electronics, Inc.

do_install:append() {
    rm -rf ${D}${prefix}/src
}
