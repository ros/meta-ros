# Copyright (c) 2024-2025 Wind River Systems, Inc.

inherit pkgconfig

# ERROR: QA Issue: File '/opt/ros/jazzy/lib/python3.12/site-packages/lttngpy/_lttngpy_pybind11.cpython-312-x86_64-linux-gnu.so' from lttngpy was already stripped, this will prevent future debugging! [already-stripped]
INSANE_SKIP:${PN} += "already-stripped"
