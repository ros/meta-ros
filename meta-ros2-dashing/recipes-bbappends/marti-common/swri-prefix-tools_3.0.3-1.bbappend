# Copyright (c) 2019 LG Electronics, Inc.

ROS_EXEC_DEPENDS_remove = "python-psutil"
ROS_EXEC_DEPENDS_append = " python3-psutil"

# ERROR: swri-prefix-tools-3.0.3-1-r0 do_package_qa: QA Issue: /usr/bin/xterm_prefix_normal contained in package swri-prefix-tools requires /bin/bash, but no providers found in RDEPENDS_swri-prefix-tools? [file-rdeps]
RDEPENDS_${PN} += "bash"
