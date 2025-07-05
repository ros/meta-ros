# Copyright (c) 2023 Wind River Systems, Inc.

# ERROR: QA Issue: /usr/lib/ur_bringup/start_ursim.sh contained in package ur-bringup requires /bin/bash, but no providers found in RDEPENDS:ur-bringup? [file-rdeps]
RDEPENDS:${PN} += "bash"
