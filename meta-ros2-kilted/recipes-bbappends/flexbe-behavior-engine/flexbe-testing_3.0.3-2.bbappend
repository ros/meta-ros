# Copyright (c) 2024 Wind River Systems, Inc.

# ERROR: flexbe-testing-3.0.3-1-r0 do_package_qa: QA Issue: /opt/ros/rolling/lib/flexbe_testing/testing_node contained in package flexbe-testing requires /bin/bash, but no providers found in RDEPENDS:flexbe-testing? [file-rdeps]
RDEPENDS:${PN} += "bash"
