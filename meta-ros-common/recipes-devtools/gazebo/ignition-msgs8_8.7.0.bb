# Copyright (c) 2024 Wind River Systems, Inc.

include ignition-msgs8.inc

DEPENDS = "ignition-cmake2 ignition-math6 libtinyxml2 protobuf protobuf-native ${PN}-native"

EXTRA_OECMAKE += " -DINSTALL_IGN_MSGS_GEN_EXECUTABLE:BOOL=OFF -DIGN_MSGS_GEN_EXECUTABLE=${WORKDIR}/recipe-sysroot-native/usr/bin/ign_msgs_gen"

FILES:${PN} += " \
    ${libdir}/ruby/ignition/cmdmsgs8.rb \
    ${libdir}/ruby/ignition/msgs8/* \
    ${datadir}/gz/gz1.completion.d/msgs8.bash_completion.sh \
    ${datadir}/ignition/msgs8.yaml \
"
