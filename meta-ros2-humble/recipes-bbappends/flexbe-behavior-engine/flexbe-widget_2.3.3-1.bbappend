# Copyright (c) 2023 Wind River Systems, Inc.

# ERROR: QA Issue: /usr/lib/flexbe_widget/evaluate_logs contained in package flexbe-widget requires /bin/bash, but no providers found in RDEPENDS:flexbe-widget? [file-rdeps]
RDEPENDS:${PN} += "bash"
