# Copyright (c) 2020 LG Electronics, Inc.

# ERROR: QA Issue: libphidget21: Files/directories were installed but not shipped in any package:
#   /usr/opt/ros/melodic/lib/libphidget21.so.0
#   /usr/opt/ros/melodic/lib/libphidget21.so.0.0.0
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# libphidget21: 2 installed and not shipped files. [installed-vs-shipped]
FILES_${PN} += "${ros_libdir}/*${SOLIBS}"

# ERROR: libphidget21-0.7.9-1-r0 do_package_qa: QA Issue: non -dev/-dbg/nativesdk- package contains symlink .so: libphidget21 path '/work/qemux86-webos-linux/libphidget21/0.7.9-1-r0/packages-split/libphidget21/usr/opt/ros/melodic/lib/libphidget21.so' [dev-so]
inherit ros_insane_dev_so
