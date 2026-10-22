# Copyright (c) 2026 Wind River Systems, Inc.

LICENSE = "BSD-3-Clause & Apache-2.0"

inherit python3targetconfig

# ERROR: point-cloud-transport-py-5.4.3-1-r0 do_package: QA Issue: File '/opt/ros/lyrical/lib/python3.14/site-packages/point_cloud_transport_py/_codec.cpython-314-x86_64-linux-gnu.so' from point-cloud-transport-py was already stripped, this will prevent future debugging! [already-stripped]
# ERROR: point-cloud-transport-py-5.4.3-1-r0 do_package: QA Issue: File '/opt/ros/lyrical/lib/python3.14/site-packages/point_cloud_transport_py/_point_cloud_transport.cpython-314-x86_64-linux-gnu.so' from point-cloud-transport-py was already stripped, this will prevent future debugging! [already-stripped]
INSANE_SKIP:${PN} += "already-stripped"
