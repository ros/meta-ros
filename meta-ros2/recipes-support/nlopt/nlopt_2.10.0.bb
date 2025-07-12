DESCRIPTION = "Library for nonlinear optimization, wrapping many algorithms for global and local, constrained or unconstrained, optimization"
LICENSE = "MIT & LGPL-2.1-or-later & BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=bd64d5de9621ced0bbf488c45413e534 \
                    file://COPYRIGHT;md5=1b4ae9cf9d4ec57f6dc120948e9b483a \
                    file://doc/docs/NLopt_License_and_Copyright.md;md5=9a4df202e8a0eb3830515fbd3cad5b8e \
                    file://src/algs/ags/COPYRIGHT;md5=df8018c0130b3c4b5961d163c169567b \
                    file://src/algs/bobyqa/COPYRIGHT;md5=700dca4c1a2d3517d2e372b064b09ec5 \
                    file://src/algs/cobyla/COPYRIGHT;md5=7f9129c306a5785c7913b8a5883934bf \
                    file://src/algs/direct/COPYING;md5=d0c85669acd941e21db1c3564aea3ea7 \
                    file://src/algs/esch/COPYRIGHT;md5=1b77b615ff4a4c9471595d4ca4acc1ea \
                    file://src/algs/luksan/COPYRIGHT;md5=409138dd9d869c2e8ddeae8d5d039eb2 \
                    file://src/algs/newuoa/COPYRIGHT;md5=69279a3d362f3df7cde059e749ba6458 \
                    file://src/algs/slsqp/COPYRIGHT;md5=bbfce7f9ce99c7b4d60b37c4a8db5ec9 \
                    file://src/algs/stogo/COPYRIGHT;md5=4db779c8963e07fd1ba73ed315b94013"

SRC_URI = "git://github.com/stevengj/nlopt.git;protocol=https;branch=master"

SRCREV = "7d04da19236148f9ae9d8dfa470a2264f5d2aa33"

DEPENDS = "swig-native"

inherit cmake python3-dir python3native

EXTRA_OECMAKE = "-DCMAKE_SKIP_RPATH=ON"
