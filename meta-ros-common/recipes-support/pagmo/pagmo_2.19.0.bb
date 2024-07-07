LICENSE = "LGPL-3.0-only & MIT & GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING.gpl3;md5=11cc2d3ee574f9d6b7ee797bdce4d423 \
                    file://COPYING.lgpl3;md5=6a6a8e020838b23406c81b19c1d46df6 \
                    file://cmake_modules/yacma/LICENSE;md5=28912171f281b7a4e03f7917f542a27c"

SRC_URI = "git://github.com/esa/pagmo2.git;protocol=https;branch=master"

SRCREV = "27ae9159f4fcd11bb93de0ae8189d15352655b0a"

S = "${WORKDIR}/git"

inherit cmake

DEPENDS = " \
  boost \
  ipopt \
  libeigen \
  nlopt \
  tbb \
"
