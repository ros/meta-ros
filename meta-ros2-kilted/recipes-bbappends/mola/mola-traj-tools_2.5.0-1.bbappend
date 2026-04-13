# Copyright (c) 2024 Wind River Systems, Inc.

# ERROR: mola-traj-tools-1.0.5-1-r0 do_package_qa: QA Issue: /opt/ros/rolling/bin/ncd-csv2tum contained in package mola-traj-tools requires /bin/env, but no providers found in RDEPENDS:mola-traj-tools? [file-rdeps]
do_install:append() {
    # Modify the scripts to use /usr/bin/env
    sed -i -e '1s|^#!.*|#!/usr/bin/env python3|' ${D}${ros_bindir}/ncd-csv2tum
}
