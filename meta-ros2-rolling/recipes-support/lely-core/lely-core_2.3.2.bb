# Copyright (c) 2024 Wind River Systems, Inc.

DESCRIPTION = "A collection of C and C++ libraries and tools, providing hih-performance I/O and sensor/actuator control for robotics and IoT applications"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI = "git://gitlab.com/lely_industries/lely-core.git;protocol=https;branch=v2.3"

PV = "2.3.2+git${SRCPV}"
SRCREV = "7824cbb2ac08d091c4fa2fb397669b938de9e3f5"

S = "${WORKDIR}/git"

inherit pkgconfig autotools setuptools3-base

DEPENDS += "python3-setuptools-native python3-wheel-native"

EXTRA_OECONF += " --disable-cython --disable-tests --disable-python2"

PACKAGES =+ " \
    liblely-can \
    liblely-can1 \
    liblely-co \
    liblely-co2 \
    liblely-coapp \
    liblely-coapp2 \
    liblely-co-tools \
    liblely-ev \
    liblely-ev2 \
    liblely-io \
    liblely-io1 \
    liblely-io2 \
    liblely-io2-2 \
    liblely-libc \
    liblely-libc2 \
    liblely-tap \
    liblely-tap2 \
    liblely-util \
    liblely-util2 \
    python3-dcf-tools \
    python3-lely-can \
    python3-lely-io \
"

FILES:liblely-can1 = " \
    ${libdir}/liblely-can${SOLIBS} \
"

FILES:liblely-can-dev = " \
    ${includedir}/lely/can/ \
    ${libdir}/liblely-can.a \
    ${libdir}/liblely-can.so \
    ${libdir}/pkgconfig/liblely-can.pc \
"

FILES:liblely-co2 = " \
    ${libdir}/liblely-co${SOLIBS} \
"

FILES:liblely-coapp2 = " \
    ${libdir}/liblely-coapp${SOLIBS} \
"

FILES:liblely-coapp-dev = " \
    ${includedir}/lely/coapp/ \
    ${libdir}/liblely-coapp.a \
    ${libdir}/liblely-coapp.so \
    ${libdir}/pkgconfig/liblely-coapp.pc \
"

FILES:liblely-co-dev = " \
    ${includedir}/lely/co/ \
    ${libdir}/liblely-co.a \
    ${libdir}/liblely-co.so \
    ${libdir}/pkgconfig/liblely-co.pc \
"

FILES:liblely-co-dev-tools = " \
    ${bindir}/dcf2c \
"

FILES:liblely-co-tools = " \
    {$sysconfdir}/cocatd.dcf \
    {$sysconfdir}/coctl.dcf \
    ${bindir}/can2udp \
    ${bindir}/cocat \
    ${bindir}/cocatd \
    ${bindir}/coctl \
"

FILES:liblely-ev2 = " \
    ${libdir}/liblely-ev${SOLIBS} \
"

FILES:liblely-ev-dev = " \
    ${includedir}/lely/ev/ \
    ${libdir}/liblely-ev.a \
    ${libdir}/liblely-ev.so \
    ${libdir}/pkgconfig/liblely-ev.pc \
"

FILES:liblely-io1 = " \
    ${libdir}/liblely-io${SOLIBS} \
"

FILES:liblely-io2-2 = " \
    ${libdir}/liblely-io2${SOLIBS} \
"

FILES:liblely-io2-dev = " \
    ${includedir}/lely/io2/ \
    ${libdir}/liblely-io2.a \
    ${libdir}/liblely-io2.so \
    ${libdir}/pkgconfig/liblely-io2.pc \
"

FILES:liblely-io-dev = " \
    ${includedir}/lely/io/ \
    ${libdir}/liblely-io.a \
    ${libdir}/liblely-io.so \
    ${libdir}/pkgconfig/liblely-io.pc \
"

FILES:liblely-libc2 = " \
    ${libdir}/liblely-libc${SOLIBS} \
"

FILES:liblely-libc-dev = " \
    ${includedir}/lely/libc/ \
    ${includedir}/lely/*.h \
    ${libdir}/liblely-libc.a \
    ${libdir}/liblely-libc.so \
    ${libdir}/pkgconfig/liblely-libc.pc \
    ${libdir}/pkgconfig/liblely-libc_rt.pc \
"

FILES:liblely-tap2 = " \
    ${libdir}/liblely-tap${SOLIBS} \
"

FILES:liblely-tap-dev = " \
    ${includedir}/lely/tap/ \
    ${libdir}/liblely-tap.a \
    ${libdir}/liblely-tap.so \
    ${libdir}/pkgconfig/liblely-tap.pc \
"

FILES:liblely-util2 = " \
    ${libdir}/liblely-util${SOLIBS} \
"

FILES:liblely-util-dev = " \
    ${includedir}/lely/util/ \
    ${libdir}/liblely-util.a \
    ${libdir}/liblely-util.so \
    ${libdir}/pkgconfig/liblely-util.pc \
"

FILES:python3-dcf-tools = " \
    ${libdir}/python3*/dist-packages/dcf/*.py \
    ${libdir}/python3*/dist-packages/dcfgen/data/ \
    ${libdir}/python3*/dist-packages/dcfgen/*.py \
    ${libdir}/python3*/dist-packages/dcf_tools-*.egg-info/ \
    ${bindir}/dcfchk \
    ${bindir}/dcfgen \
"

FILES:python3-lely-can-dev = " \
    ${libdir}/python3*/dist-packages/lely_can/*.pxd \
"

FILES:python3-lely-can = " \
    ${libdir}/python3*/dist-packages/lely_can/*.py \
    ${libdir}/python3*/dist-packages/lely_can/*.so \
"

FILES:python3-lely-io-dev = " \
    ${libdir}/python3*/dist-packages/lely_io/*.pxd \
"

FILES:python3-lely-io = " \
    ${libdir}/python3*/dist-packages/lely_io/*.py \
    ${libdir}/python3*/dist-packages/lely_io/*.so \
"

# QA Issue: lely-core: .../dcf2dev maximum shebang size exceeded, the maximum size is 128.
#           lely-core: .../dcfchk maximum shebang size exceeded, the maximum size is 128.
#           lely-core: .../dcfgen maximum shebang size exceeded, the maximum size is 128. [shebang-size]
do_install:append() {
    # Modify the Python scripts to use the runtime path to Python 
    sed -i -e '1s|^#!.*|#!/usr/bin/env python3|' ${D}${bindir}/dcf2dev
    sed -i -e '1s|^#!.*|#!/usr/bin/env python3|' ${D}${bindir}/dcfchk
    sed -i -e '1s|^#!.*|#!/usr/bin/env python3|' ${D}${bindir}/dcfgen
}

BBCLASSEXTEND = "native nativesdk"
