# Copyright (c) 2024 Wind River Systems, Inc.

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package kobuki-core contains symlink .so '/usr/lib/libkobuki_core.so' [dev-so]
FILES:${PN}-dev += "${libdir}/libkobuki_core.so"
