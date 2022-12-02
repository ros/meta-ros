# Copyright (c) 2020 LG Electronics, Inc.

# spdlog is header only library and PN is empty, so it wasn't created
RDEPENDS_${PN}_remove = "spdlog"

# ERROR: spdlog-vendor-1.1.1-1-r0 do_package_qa: QA Issue: non -dev/-dbg/nativesdk- package contains symlink .so: spdlog-vendor path '/work/aarch64-oe-linux/spdlog-vendor/1.1.1-1-r0/packages-split/spdlog-vendor/usr/lib/libspdlog.so' [dev-so]
inherit ros_insane_dev_so
