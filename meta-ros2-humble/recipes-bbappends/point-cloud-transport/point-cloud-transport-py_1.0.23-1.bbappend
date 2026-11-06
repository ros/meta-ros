# Copyright (c) 2024 Wind River Systems, Inc.

LICENSE = "BSD-3-Clause AND Apache-2.0"

# QA Issue:File was already stripped, this will prevent future debugging! [already-stripped]
INSANE_SKIP:${PN} += "already-stripped"
