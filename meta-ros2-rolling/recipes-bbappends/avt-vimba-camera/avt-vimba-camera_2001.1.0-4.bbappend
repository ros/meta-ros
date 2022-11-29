# Copyright (c) 2022 Wind River Systems, Inc.

# ERROR: QA Issue: File '/usr/lib/libVimbaC.so' from avt-vimba-camera was already stripped, this will prevent future debugging! [already-stripped]
# ERROR: QA Issue: File '/usr/lib/libVimbaCPP.so' from avt-vimba-camera was already stripped, this will prevent future debugging! [already-stripped]
INSANE_SKIP:${PN} += "already-stripped"
