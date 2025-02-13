# Copyright (c) 2024 Wind River Systems, Inc.

LICENSE = "Apache-2.0"

LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-transport.git;protocol=https;branch=ign-transport11"

SRCREV = "69e9592544c36d4e10eed74953258662569d91fd"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

DEPENDS = " \
    cppzmq \
    ignition-cmake2 \
    ignition-msgs8 \
    ignition-utils1 \
    protobuf \
    protobuf-native \
    sqlite3 \
    util-linux-libuuid \
    zeromq \
"

RDEPENDS:${PN} += "ruby"

EXTRA_OECMAKE += " \
    -DPROTOBUF_PROTOC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/protoc \
"

FILES:${PN} += " \
  /usr/lib/ruby/gz/cmdtransport11.rb \
  /usr/lib/ruby/ignition/cmdparam11.rb \
  /usr/lib/ruby/ignition/cmdlog11.rb \
  /usr/share/gz/gz1.completion.d/transport11.bash_completion.sh \
  /usr/share/ignition/transport11.yaml \
  /usr/share/ignition/transportparam11.yaml \
  /usr/share/ignition/transportlog11.yaml \
  /usr/share/ignition/ignition-transport11/sql/0.1.0.sql \
"

BBCLASSEXTEND = "native nativesdk"
