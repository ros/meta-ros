# Copyright (c) 2024 Wind River Systems, Inc.

LICENSE = "Apache-2.0"

LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-transport.git;protocol=https;branch=ign-transport11 \
           file://add-compatibility-with-protobuf-28.patch"

SRCREV = "3e534addedf63a206cf579c80acf994b12c698ec"


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
