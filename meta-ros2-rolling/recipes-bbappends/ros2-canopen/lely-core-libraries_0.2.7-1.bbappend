# Copyright (c) 2024 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://repackage-lely-core.patch"

SRCREV_upstream = "7824cbb2ac08d091c4fa2fb397669b938de9e3f5"

DEPENDS += "lely-core lely-core-native"

# CMake Error:
# Running
#  'ninja' '-C' 'TOPDIR/tmp-glibc/work/core2-64-oe-linux/lely-core-libraries/0.2.7-1-r0/build' '-t' 'recompact'
# failed with:
#  ninja: error: build.ninja:185: bad $-escape (literal $ must be written as $$)
#
# This is caused by a hard-coded command that violates ninja syntax: cd <DIR> && $(MAKE)
OECMAKE_GENERATOR = "Unix Makefiles"

PACKAGES += "python3-cogen"

FILES:python3-cogen = " \
    ${libdir}/python*/site-packages/cogen/cogen.py \
    ${libdir}/cogen/cogen \
    ${bindir}/cogen \
"

# QA Issue: python3-cogen: /usr/lib/cogen/cogen maximum shebang size exceeded, the maximum size is 128. [shebang-size]
# QA Issue: /usr/lib/cogen/cogen contained in package python3-cogen requires .../python3, but no providers found in RDEPENDS:python3-cogen? [file-rdeps]
# QA Issue: lely-core-libraries: /usr/bin/cogen maximum shebang size exceeded, the maximum size is 128. [shebang-size]
# QA Issue: /usr/bin/cogen contained in package lely-core-libraries requires .../python3, but no providers found in RDEPENDS:lely-core-libraries? [file-rdeps]
do_install:append() {
    # Modify the Python scripts to use the runtime path to Python 
    sed -i -e '1s|^#!.*|#!/usr/bin/env python3|' ${D}${bindir}/cogen
    sed -i -e '1s|^#!.*|#!/usr/bin/env python3|' ${D}${libdir}/cogen/cogen
}

BBCLASSEXTEND = "native nativesdk"
