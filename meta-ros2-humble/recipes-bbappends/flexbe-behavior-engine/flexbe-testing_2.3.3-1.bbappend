# Copyright (c) 2023 Wind River Systems, Inc.

# ERROR: QA Issue: /usr/lib/flexbe_testing/testing_node contained in package flexbe-testing requires /bin/bash, but no providers found in RDEPENDS:flexbe-testing? [file-rdeps]
RDEPENDS:${PN} += "bash"
