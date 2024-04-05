# Copyright (c) 2023 Wind River Systems, Inc.

DEPENDS += " \
    protobuf-native \
"

# ERROR: ecal-5.12.0-3-r0 do_package_qa: QA Issue: non -dev/-dbg/nativesdk- package ecal contains symlink .so '/usr/lib/libecal_app_pb.so'
# non -dev/-dbg/nativesdk- package ecal contains symlink .so '/usr/lib/libecal_core_c.so'
# non -dev/-dbg/nativesdk- package ecal contains symlink .so '/usr/lib/libecal_ecaltime_pb.so'
# non -dev/-dbg/nativesdk- package ecal contains symlink .so '/usr/lib/libecaltime-linuxptp.so'
# non -dev/-dbg/nativesdk- package ecal contains symlink .so '/usr/lib/libecal_core.so'
# non -dev/-dbg/nativesdk- package ecal contains symlink .so '/usr/lib/libecaltime-localtime.so'
# non -dev/-dbg/nativesdk- package ecal contains symlink .so '/usr/lib/libecal_app_pb.so'
# non -dev/-dbg/nativesdk- package ecal contains symlink .so '/usr/lib/libecal_core_pb.so'
# non -dev/-dbg/nativesdk- package ecal contains symlink .so '/usr/lib/libecaltime-simtime.so' [dev-so]
FILES:${PN}-dev += " \
    ${libdir}/libnlohmann_json_schema_validator.so \
    ${libdir}/libecal_core_c.so \
    ${libdir}/libecal_ecaltime_pb.so \
    ${libdir}/libecaltime-linuxptp.so \
    ${libdir}/libecal_core.so \
    ${libdir}/libecaltime-localtime.so \
    ${libdir}/libecal_app_pb.so \
    ${libdir}/libecal_core_pb.so \
    ${libdir}/libecaltime-simtime.so \
"
