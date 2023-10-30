# Copyright (c) 2022 Wind River Systems, Inc.

# ERROR: QA Issue: robot-upstart: Files/directories were installed but not shipped in any package:
#   /usr/share/lib
#   /usr/share/lib/robot_upstart
#   /usr/share/lib/robot_upstart/scripts
#   /usr/share/lib/robot_upstart/scripts/install
#   /usr/share/lib/robot_upstart/scripts/uninstall
#   /usr/share/lib/robot_upstart/scripts/mkxacro
#   /usr/share/lib/robot_upstart/scripts/mutate_files
#   /usr/share/lib/robot_upstart/scripts/getifip
#   /usr/share/lib/robot_upstart/scripts/mklaunch
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# robot-upstart: 9 installed and not shipped files. [installed-vs-shipped]
FILES:${PN} += "${datadir}/lib/robot_upstart"

# ERROR: robot-upstart-1.0.2-1-r0 do_package_qa: QA Issue: /usr/share/robot_upstart/scripts/mkxacro contained in package robot-upstart requires /bin/bash, but no providers found in RDEPENDS:robot-upstart? [file-rdeps]
RDEPENDS:${PN} += "bash"
