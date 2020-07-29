# Copyright (c) 2020 LG Electronics, Inc.

# WARNING: moveit-ros-benchmarks-1.0.2-1-r0 do_package: QA Issue: moveit-ros-benchmarks: Files/directories were installed but not shipped in any package:
#   /opt/ros/melodic/lib/libmoveit_ros_benchmarks.so.1.0.2
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# moveit-ros-benchmarks: 1 installed and not shipped files. [installed-vs-shipped]
#
# ERROR: moveit-ros-benchmarks-1.0.2-1-r0 do_package_qa: QA Issue: non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-benchmarks path '/work/aarch64-oe-linux/moveit-ros-benchmarks/1.0.2-1-r0/packages-split/moveit-ros-benchmarks/opt/ros/melodic/lib/libmoveit_ros_benchmarks.so' [dev-so]
# ERROR: moveit-ros-benchmarks-1.0.2-1-r0 do_package_qa: QA Issue: /opt/ros/melodic/lib/moveit_ros_benchmarks/moveit_run_benchmark contained in package moveit-ros-benchmarks requires libmoveit_ros_benchmarks.so.1.0.2()(64bit), but no providers found in RDEPENDS_moveit-ros-benchmarks? [file-rdeps]
# ERROR: moveit-ros-benchmarks-1.0.2-1-r0 do_package_qa: QA run found fatal errors. Please consider fixing them.
inherit ros_insane_dev_so
