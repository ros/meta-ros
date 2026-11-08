# Copyright (c) 2026 Wind River Systems, Inc.

# ERROR: moveit-py-2.5.10-1-r0 do_package: QA Issue: File '/opt/ros/humble/lib/python3.12/site-packages/moveit/core.cpython-312-x86_64-linux-gnu.so' from moveit-py was already stripped, this will prevent future debugging! [already-stripped]
# ERROR: moveit-py-2.5.10-1-r0 do_package: QA Issue: File '/opt/ros/humble/lib/python3.12/site-packages/moveit/planning.cpython-312-x86_64-linux-gnu.so' from moveit-py was already stripped, this will prevent future debugging! [already-stripped]
INSANE_SKIP:${PN} += "already-stripped"
