# Copyright (c) 2026 Wind River Systems, Inc.

inherit python3targetconfig

# ERROR: image-transport-py-6.4.10-1-r0 do_package: QA Issue: File '/opt/ros/lyrical/lib/python3.14/site-packages/image_transport_py/_image_transport.cpython-314-x86_64-linux-gnu.so' from image-transport-py was already stripped, this will prevent future debugging! [already-stripped]
INSANE_SKIP:${PN} += "already-stripped"
