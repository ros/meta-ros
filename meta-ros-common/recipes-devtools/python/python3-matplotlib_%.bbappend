# Copyright (c) 2026 Wind River Systems, Inc.

# ERROR: python3-matplotlib-3.10.8-r0 do_package_qa: QA Issue: File ... in package python3-matplotlib-dbg contains reference to TMPDIR [buildpaths]
INSANE_SKIP:${PN}-dbg += "buildpaths"
