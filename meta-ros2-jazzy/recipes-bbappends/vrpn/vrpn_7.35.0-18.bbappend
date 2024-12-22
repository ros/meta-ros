# Copyright (c) 2022 Wind River Systems, Inc.

# ERROR: QA Issue: vrpn: Files/directories were installed but not shipped in any package:
#  /usr/share/quatlib
#  /usr/share/quatlib/cmake
#  /usr/share/quatlib/cmake/quatlibConfig.cmake
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
FILES:${PN}-dev += "${datadir}/quatlib/cmake/*.cmake"
