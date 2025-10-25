# Copyright (c) 2025 Wind River Systems, Inc.

# QA Issue: .../lttng-gen-tp maximum shebang size exceeded, the maximum size is 128. [shebang-size]

do_install:append() {
    # Modify the Python scripts to use the runtime path to Python
    sed -i -e '1s|^#!.*|#!/usr/bin/env python3|' ${D}${bindir}/lttng-gen-tp
}

BBCLASSEXTEND = "native nativesdk"
