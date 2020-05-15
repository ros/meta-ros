# Copyright (c) 2020 LG Electronics, Inc.

# WARNING: moveit-fake-controller-manager-1.0.2-1-r0 do_package: QA Issue: moveit-fake-controller-manager: Files/directories were installed but not shipped in any package:
#   /opt/ros/melodic/lib/libmoveit_fake_controller_manager.so.1.0.2
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# moveit-fake-controller-manager: 1 installed and not shipped files. [installed-vs-shipped]
# ERROR: moveit-fake-controller-manager-1.0.2-1-r0 do_package_qa: QA Issue: non -dev/-dbg/nativesdk- package contains symlink .so: moveit-fake-controller-manager path '/work/core2-64-oe-linux/moveit-fake-controller-manager/1.0.2-1-r0/packages-split/moveit-fake-controller-manager/opt/ros/melodic/lib/libmoveit_fake_controller_manager.so' [dev-so]
# ERROR: moveit-fake-controller-manager-1.0.2-1-r0 do_package_qa: QA run found fatal errors. Please consider fixing them.
# ERROR: moveit-fake-controller-manager-1.0.2-1-r0 do_package_qa: Function failed: do_package_qa
inherit ros_insane_dev_so
