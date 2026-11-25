# Copyright (c) 2026 Wind River Systems, Inc.

# ERROR: point-cloud-transport-py-4.0.9-1-r0 do_package: QA Issue: File '/opt/ros/jazzy/lib/python3.12/site-packages/point_cloud_transport_py/_codec.cpython-312-x86_64-linux-gnu.so' from point-cloud-transport-py was already stripped, this will prevent future debugging! [already-stripped]
# ERROR: point-cloud-transport-py-4.0.9-1-r0 do_package: QA Issue: File '/opt/ros/jazzy/lib/python3.12/site-packages/point_cloud_transport_py/_point_cloud_transport.cpython-312-x86_64-linux-gnu.so' from point-cloud-transport-py was already stripped, this will prevent future debugging! [already-stripped]
INSANE_SKIP:${PN} += "already-stripped"
