# Copyright (c) 2023 Wind River Systems, Inc.

LICENSE = "BSD-2-Clause"

ROS_BUILD_DEPENDS += "matio"

ROS_EXEC_DEPENDS:remove = "${ROS_UNRESOLVED_DEP-simde}"

inherit python3native

EXTRA_OECMAKE += "-DCMAKE_BUILD_TYPE=Release -DBUILD_TESTING=OFF -DBUILD_PYTHON_INTERFACE=ON"

# ERROR: proxsuite-0.3.6-2-r0 do_package: QA Issue: proxsuite: Files/directories were installed but not shipped in any package:
#   /usr/share/ament_index
#   /usr/share/ament_index/resource_index
#   /usr/share/ament_index/resource_index/packages
#   /usr/share/ament_index/resource_index/packages/proxsuite
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# proxsuite: 4 installed and not shipped files. [installed-vs-shipped]
FILES:${PN}:prepend = " \
    ${datadir}/ament_index \
"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://do-not-create-install-dir-at-configure.patch"

# ERROR: proxsuite-0.7.3-1-r0 do_package: QA Issue: File '/opt/ros/jazzy/lib/python3.14/site-packages/proxsuite/proxsuite_pywrap.cpython-314-x86_64-linux-gnu.so' from proxsuite was already stripped, this will prevent future debugging! [already-stripped]
INSANE_SKIP:${PN} += "already-stripped"
