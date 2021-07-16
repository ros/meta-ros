# Copyright (c) 2020 LG Electronics, Inc.

EXTRA_OECMAKE += "-DCMAKE_BUILD_TYPE=Release -DFCL_NO_DEFAULT_RPATH=OFF ${EXTRA_OECMAKE_SSE}"
EXTRA_OECMAKE_SSE = "-DFCL_USE_X64_SSE=OFF"
EXTRA_OECMAKE_SSE:x86-64 = ""

# ERROR: fcl-0.6.1-2-r0 do_package_qa: QA Issue: non -dev/-dbg/nativesdk- package contains symlink .so: fcl path '/work/raspberrypi4-webos-linux-gnueabi/fcl/0.6.1-2-r0/packages-split/fcl/usr/lib/libfcl.so' [dev-so]
inherit ros_insane_dev_so
