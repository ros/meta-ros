# Copyright (c) 2020 LG Electronics, Inc.

# find_package(Genicam REQUIRED NO_CMAKE_PATH PATHS ${CMAKE_CURRENT_SOURCE_DIR}/genicam CONFIG NO_DEFAULT_PATH)
# doesn't work for some reason, help it by setting Genicam_DIR
EXTRA_OECMAKE += "-DGenicam_DIR=${S}/genicam"

# These are prebuilt binaries
# ERROR: rc-genicam-api-2.3.3-1-r0 do_package: QA Issue: File '/usr/lib/libGenApi_gcc46_v3_1.so' from rc-genicam-api was already stripped, this will prevent future debugging! [already-stripped]
# ERROR: rc-genicam-api-2.3.3-1-r0 do_package: QA Issue: File '/usr/lib/libGCBase_gcc46_v3_1.so' from rc-genicam-api was already stripped, this will prevent future debugging! [already-stripped]
# ERROR: rc-genicam-api-2.3.3-1-r0 do_package: QA Issue: File '/usr/lib/libNodeMapData_gcc46_v3_1.so' from rc-genicam-api was already stripped, this will prevent future debugging! [already-stripped]
# ERROR: rc-genicam-api-2.3.3-1-r0 do_package: QA Issue: File '/usr/lib/libXmlParser_gcc46_v3_1.so' from rc-genicam-api was already stripped, this will prevent future debugging! [already-stripped]
# ERROR: rc-genicam-api-2.3.3-1-r0 do_package: QA Issue: File '/usr/lib/liblog4cpp_gcc46_v3_1.so' from rc-genicam-api was already stripped, this will prevent future debugging! [already-stripped]
# ERROR: rc-genicam-api-2.3.3-1-r0 do_package: QA Issue: File '/usr/lib/libLog_gcc46_v3_1.so' from rc-genicam-api was already stripped, this will prevent future debugging! [already-stripped]
# ERROR: rc-genicam-api-2.3.3-1-r0 do_package: QA Issue: File '/usr/lib/libMathParser_gcc46_v3_1.so' from rc-genicam-api was already stripped, this will prevent future debugging! [already-stripped]
INSANE_SKIP_${PN} += "already-stripped"

# ERROR: rc-genicam-api-2.3.3-1-r0 do_package_qa: QA Issue: non -dev/-dbg/nativesdk- package contains symlink .so: rc-genicam-api path '/work/raspberrypi4-webos-linux-gnueabi/rc-genicam-api/2.3.3-1-r0/packages-split/rc-genicam-api/usr/lib/librc_genicam_api.so' [dev-so]
inherit ros_insane_dev_so

# ERROR: rc-genicam-api-2.3.3-1-r0 do_package_qa: QA Issue: /usr/share/rc_genicam_api/net_perf_check.sh contained in package rc-genicam-api requires /bin/bash, but no providers found in RDEPENDS_rc-genicam-api? [file-rdeps]
RDEPENDS_${PN} += "bash"

# This is needed only for webOS OSE and it's not in meta-ros-webos, because
# then meta-ros-webos would need to include this .bbappend just when
# meta-ros1-melodic layer is included
VIRTUAL-RUNTIME_bash ?= "bash"
RDEPENDS_${PN}_append_class-target_webos = " ${VIRTUAL-RUNTIME_bash}"
RDEPENDS_${PN}_remove_class-target_webos = "${@oe.utils.conditional('WEBOS_PREFERRED_PROVIDER_FOR_BASH', 'busybox', 'bash', '', d)}"
