# Copyright (c) 2023 Wind River Systems, Inc.

# ERROR: QA Issue: /usr/lib/pmb2_2dnav/record_rgbd.sh contained in package pmb2-2dnav requires /bin/bash, but no providers found in RDEPENDS:pmb2-2dnav? [file-rdeps]
RDEPENDS:${PN} += "bash"
