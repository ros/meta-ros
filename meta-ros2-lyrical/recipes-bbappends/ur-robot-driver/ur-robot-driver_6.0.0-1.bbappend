# Copyright (c) 2023 Wind River Systems, Inc.

# ERROR: QA Issue: /usr/lib/ur_robot_driver/start_ursim.sh contained in package ur-robot-driver requires /bin/bash, but no providers found in RDEPENDS:ur-robot-driver? [file-rdeps]
RDEPENDS:${PN} += "bash"
