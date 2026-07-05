# Copyright (c) 2023-2026 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://remove-ament-target-dependencies.patch \
            file://add-bullet-dependency.patch"

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package moveit-py contains symlink .so '/usr/lib/libmoveit_py_utils.so' [dev-so]
inherit ros_insane_dev_so

# ERROR: moveit-py-2.14.3-1-r0 do_package: QA Issue: File '/opt/ros/kilted/lib/python3.14/site-packages/moveit/core.cpython-314-x86_64-linux-gnu.so' from moveit-py was already stripped, this will prevent future debugging! [already-stripped]
# ERROR: moveit-py-2.14.3-1-r0 do_package: QA Issue: File '/opt/ros/kilted/lib/python3.14/site-packages/moveit/planning.cpython-314-x86_64-linux-gnu.so' from moveit-py was already stripped, this will prevent future debugging! [already-stripped]
INSANE_SKIP:${PN} += "already-stripped"
