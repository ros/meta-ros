# Copyright (c) 2019 LG Electronics, Inc.
# Copyright (c) 2022 Wind River Systems, Inc.

# ERROR: ament-download-0.0.5-1-r0 do_package_qa: QA Issue: /usr/share/ament_download/cmake/download_checkmd5.py contained in package ament-download-dev requires /bin/env, but no providers found in RDEPENDS:ament-download-dev? [file-rdeps]
# RDEPENDS:${PN}-dev += "coreutils"

do_install:append() {
    sed -i 's@^#!/bin/env@#!/usr/bin/env@g' ${D}${datadir}/ament_download/cmake/download_checkmd5.py
}
