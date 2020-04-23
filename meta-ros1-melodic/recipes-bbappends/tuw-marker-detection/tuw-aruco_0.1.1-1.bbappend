# Copyright (c) 2020 LG Electronics, Inc.

# ERROR: tuw-aruco-0.1.1-1-r0 do_package: QA Issue: tuw-aruco: Files/directories were installed but not shipped in any package:
#  /usr/opt/ros/melodic/lib/libaruco.so.2.0
#  /usr/opt/ros/melodic/lib/libaruco.so.2.0.9
#  /usr/opt/ros/melodic/lib/cmake
#  /usr/opt/ros/melodic/lib/cmake/Findaruco.cmake
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# tuw-aruco: 4 installed and not shipped files. [installed-vs-shipped]
# or when the above is ignored, then it results in:
# ERROR: tuw-aruco-0.1.1-1-r0 do_package_qa: QA Issue: /opt/ros/melodic/bin/aruco_tracker contained in package tuw-aruco requires libaruco.so.2.0()(64bit), but no providers found in RDEPENDS_tuw-aruco? [file-rdeps]
FILES_${PN} += "${ros_libdir}/*${SOLIBS}"
FILES_${PN}-dev += "${ros_libdir}/cmake"

# ERROR: tuw-aruco-0.1.1-1-r0 do_package_qa: QA Issue: non -dev/-dbg/nativesdk- package contains symlink .so: tuw-aruco path '/work/aarch64-oe-linux/tuw-aruco/0.1.1-1-r0/packages-split/tuw-aruco/opt/ros/melodic/lib/libaruco.so' [dev-so]
inherit ros_insane_dev_so
