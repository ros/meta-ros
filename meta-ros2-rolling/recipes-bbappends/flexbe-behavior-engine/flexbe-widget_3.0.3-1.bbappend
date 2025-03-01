# Copyright (c) 2024 Wind River Systems, Inc.

LICENSE = "BSD-3-Clause"

# ERROR: flexbe-widget-3.0.3-1-r0 do_package_qa: QA Issue: /opt/ros/rolling/lib/flexbe_widget/evaluate_logs contained in package flexbe-widget requires /bin/bash, but no providers found in RDEPENDS:flexbe-widget? [file-rdeps]
RDEPENDS:${PN} += "bash"
