# Copyright (c) 2022 Wind River Systems, Inc.

# ERROR: QA Issue: ecl-license: Files/directories were installed but not shipped in any package:
#  /usr/share/licenses
#  /usr/share/licenses/COPYING
#  /usr/share/licenses/AUTHORS
#  /usr/share/licenses/COPYING-PLAIN
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# ecl-license: 4 installed and not shipped files. [installed-vs-shipped]
FILES:${PN} += "${datadir}/licenses/COPYING \
                ${datadir}/licenses/AUTHORS \
                ${datadir}/licenses/COPYING-PLAIN"
