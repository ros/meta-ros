# Copyright (c) 2023 Wind River Systems, Inc.

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package moveit-py contains symlink .so '/opt/ros/jazzy/lib/libmoveit_py_utils.so' [dev-so]
inherit ros_insane_dev_so
# ERROR: moveit-py-2.12.4-1-r0 do_package: QA Issue: File '/opt/ros/jazzy/lib/python3.12/site-packages/moveit/core.cpython-312-x86_64-linux-gnu.so' from moveit-py was already stripped, this will prevent future debugging! [already-stripped]
# ERROR: moveit-py-2.12.4-1-r0 do_package: QA Issue: File '/opt/ros/jazzy/lib/python3.12/site-packages/moveit/planning.cpython-312-x86_64-linux-gnu.so' from moveit-py was already stripped, this will prevent future debugging! [already-stripped]
INSANE_SKIP:${PN} += "already-stripped"
