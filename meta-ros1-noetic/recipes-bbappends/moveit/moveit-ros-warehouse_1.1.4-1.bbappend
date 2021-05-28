# Copyright (c) 2020 LG Electronics, Inc.

# WARNING: moveit-ros-warehouse-1.0.2-1-r0 do_package: QA Issue: moveit-ros-warehouse: Files/directories were installed but not shipped in any package:
#   /opt/ros/melodic/lib/libmoveit_warehouse.so.1.0.2
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# moveit-ros-warehouse: 1 installed and not shipped files. [installed-vs-shipped]
# ERROR: moveit-ros-warehouse-1.0.2-1-r0 do_package_qa: QA Issue: non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-warehouse path '/work/core2-64-oe-linux/moveit-ros-warehouse/1.0.2-1-r0/packages-split/moveit-ros-warehouse/opt/ros/melodic/lib/libmoveit_warehouse.so' [dev-so]
# ERROR: moveit-ros-warehouse-1.0.2-1-r0 do_package_qa: QA Issue: /opt/ros/melodic/lib/moveit_ros_warehouse/moveit_warehouse_services contained in package moveit-ros-warehouse requires libmoveit_warehouse.so.1.0.2()(64bit), but no providers found in RDEPENDS_moveit-ros-warehouse? [file-rdeps]
# ERROR: moveit-ros-warehouse-1.0.2-1-r0 do_package_qa: QA run found fatal errors. Please consider fixing them.
# ERROR: moveit-ros-warehouse-1.0.2-1-r0 do_package_qa: Function failed: do_package_qa
# ERROR: Logfile of failure stored in: /jenkins/mjansa/build/ros/ros1-melodic-thud/tmp-glibc/work/core2-64-oe-linux/moveit-ros-warehouse/1.0.2-1-r0/temp/log.do_package_qa.64674
# ERROR: Task (/jenkins/mjansa/build/ros/ros1-melodic-thud/meta-ros/meta-ros1-melodic/generated-recipes/moveit/moveit-ros-warehouse_1.0.2-1.bb:do_package_qa) failed with exit code '1'
inherit ros_insane_dev_so
