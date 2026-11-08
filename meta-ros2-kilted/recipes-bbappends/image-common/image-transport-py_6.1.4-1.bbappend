# Copyright (c) 2026 Wind River Systems, Inc.

# ERROR: image-transport-py-6.1.4-1-r0 do_package: QA Issue: File '/opt/ros/kilted/lib/python3.12/site-packages/image_transport_py/_image_transport.cpython-312-x86_64-linux-gnu.so' from image-transport-py was already stripped, this will prevent future debugging! [already-stripped]
INSANE_SKIP:${PN} += "already-stripped"
