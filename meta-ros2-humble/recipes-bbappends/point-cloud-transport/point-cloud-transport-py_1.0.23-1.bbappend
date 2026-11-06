# Copyright (c) 2024 Wind River Systems, Inc.


inherit python3targetconfig

# QA Issue:File was already stripped, this will prevent future debugging! [already-stripped]
INSANE_SKIP:${PN} += "already-stripped"
