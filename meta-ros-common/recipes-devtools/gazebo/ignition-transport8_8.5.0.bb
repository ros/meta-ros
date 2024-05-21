LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-transport.git;protocol=https;branch=main"

SRCREV = "db86f9b8838187a290ecad968dc5fc432739466a"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = ""

DEPENDS = " \
    ignition-cmake2 \
    ignition-msgs5 \
    ignition-utils1 \
    sqlite3 \
    util-linux-libuuid \
    zeromq \
    cppzmq \
"

RDEPENDS:${PN} += "ruby"

FILES:${PN} += " \
  ${libdir}/ruby/ignition/cmdtransport8.rb \
  ${libdir}/ruby/ignition/cmdlog8.rb \
  ${datadir}/gz/gz1.completion.d/transport8.bash_completion.sh \
  ${datadir}/ignition/transport8.yaml \
  ${datadir}/ignition/transportparam8.yaml \
  ${datadir}/ignition/transportlog8.yaml \
  ${datadir}/ignition/ignition-transport8/sql/0.1.0.sql \
"

BBCLASSEXTEND = "native nativesdk"
