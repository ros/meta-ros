include ignition-msgs5.inc

DEPENDS = "ignition-math6 libtinyxml2 protobuf protobuf-native ${PN}-native"
DEPENDS += "${PN}-native"
EXTRA_OECMAKE += " -DINSTALL_IGN_MSGS_GEN_EXECUTABLE:BOOL=OFF -DIGN_MSGS_GEN_EXECUTABLE=${WORKDIR}/recipe-sysroot-native/usr/bin/ign_msgs_gen"

FILES:${PN} += " \
    ${libdir}/ruby/ignition/cmdmsgs5.rb \
    ${libdir}/ruby/ignition/msgs5/* \
    ${datadir}/gz/gz1.completion.d/msgs5.bash_completion.sh \
    ${datadir}/ignition/msgs5.yaml \
"
