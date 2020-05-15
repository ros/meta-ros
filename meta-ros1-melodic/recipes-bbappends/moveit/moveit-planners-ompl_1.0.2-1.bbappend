# Copyright (c) 2020 LG Electronics, Inc.

# WARNING: moveit-planners-ompl-1.0.2-1-r0 do_package: QA Issue: moveit-planners-ompl: Files/directories were installed but not shipped in any package:
#   /opt/ros/melodic/lib/libmoveit_ompl_interface.so.1.0.2
#   /opt/ros/melodic/lib/libmoveit_ompl_planner_plugin.so.1.0.2
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# moveit-planners-ompl: 2 installed and not shipped files. [installed-vs-shipped]
#
# ERROR: moveit-planners-ompl-1.0.2-1-r0 do_package_qa: QA Issue:
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-planners-ompl path '/work/core2-64-oe-linux/moveit-planners-ompl/1.0.2-1-r0/packages-split/moveit-planners-ompl/opt/ros/melodic/lib/libmoveit_ompl_interface.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-planners-ompl path '/work/core2-64-oe-linux/moveit-planners-ompl/1.0.2-1-r0/packages-split/moveit-planners-ompl/opt/ros/melodic/lib/libmoveit_ompl_planner_plugin.so' [dev-so]
# ERROR: moveit-planners-ompl-1.0.2-1-r0 do_package_qa: QA Issue: /opt/ros/melodic/lib/moveit_planners_ompl/moveit_ompl_planner contained in package moveit-planners-ompl requires libmoveit_ompl_interface.so.1.0.2()(64bit), but no providers found in RDEPENDS_moveit-planners-ompl? [file-rdeps]
# ERROR: moveit-planners-ompl-1.0.2-1-r0 do_package_qa: QA run found fatal errors. Please consider fixing them.
inherit ros_insane_dev_so
