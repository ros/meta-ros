# Copyright (c) 2025 Wind River Systems, Inc.

# QA Issue: .../lttng-gen-tp maximum shebang size exceeded, the maximum size is 128. [shebang-size]
#
# The error only occurs for the native and nativesdk variants, whose ${bindir}
# is a long sysroot path. Scope the fix to those classes so that the target
# lttng-ust (and everything built on it) keeps oe-core's task signatures.

fix_lttng_gen_tp_shebang() {
    # Modify the Python scripts to use the runtime path to Python
    sed -i -e '1s|^#!.*|#!/usr/bin/env python3|' ${D}${bindir}/lttng-gen-tp
}

do_install:append:class-native() {
    fix_lttng_gen_tp_shebang
}

do_install:append:class-nativesdk() {
    fix_lttng_gen_tp_shebang
}

BBCLASSEXTEND = "native nativesdk"
