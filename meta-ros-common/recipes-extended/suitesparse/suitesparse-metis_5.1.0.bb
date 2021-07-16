# Copyright (c) 2019 LG Electronics, Inc.

require suitesparse-5.4.0.inc

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM += "file://LICENSE.txt;md5=b46727c71b60d35ad5d2f927c4a3929b"

S = "${WORKDIR}/SuiteSparse/metis-${PV}"

inherit cmake

EXTRA_OECMAKE += "-DGKLIB_PATH=${S}/GKlib -DSHARED=1"

# the shared library is named just /usr/lib/libmetis.so and it's not symlink to be included in PN-dev
FILES_SOLIBSDEV = ""
FILES:${PN} += "${libdir}/*.so"
