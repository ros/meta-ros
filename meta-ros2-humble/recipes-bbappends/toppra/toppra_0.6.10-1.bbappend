# Copyright (c) 2026 Wind River Systems, Inc.

# ERROR: toppra-0.6.10-1-r0 do_package: QA Issue: File '/opt/ros/humble/lib/python3.12/site-packages/toppra_int/toppra_int.cpython-312-x86_64-linux-gnu.so' from toppra was already stripped, this will prevent future debugging! [already-stripped]
INSANE_SKIP:${PN} += "already-stripped"
