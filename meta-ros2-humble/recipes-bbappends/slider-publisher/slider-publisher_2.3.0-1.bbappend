# Copyright (c) 2023 Wind River Systems, Inc.

# ERROR: QA Issue: /usr/lib/slider_publisher/slider_publisher contained in package slider-publisher requires /usr/bin/python3, but no providers found in RDEPENDS:slider-publisher? [file-rdeps]
RDEPENDS:${PN} = "python3-core"
