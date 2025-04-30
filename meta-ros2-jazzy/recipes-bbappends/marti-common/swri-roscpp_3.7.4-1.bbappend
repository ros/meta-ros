# Copyright (c) 2019 LG Electronics, Inc.

# ERROR: QA Issue: swri-roscpp: Files/directories were installed but not shipped in any package:
#   /usr/launch
#   /usr/launch/param_example.launch
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# swri-roscpp: 2 installed and not shipped files. [installed-vs-shipped]
FILES:${PN} += "${prefix}/launch"
