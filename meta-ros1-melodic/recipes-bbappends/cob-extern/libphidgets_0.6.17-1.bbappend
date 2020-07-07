# Copyright (c) 2020 LG Electronics, Inc.

# ERROR: QA Issue: libphidgets: Files/directories were installed but not shipped in any package:
#   /usr/opt/ros/melodic/lib/libphidget21.so.0
#   /usr/opt/ros/melodic/lib/libphidget21.so.0.0.0
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# libphidgets: 2 installed and not shipped files. [installed-vs-shipped]
FILES_${PN} += "${ros_libdir}/*${SOLIBS}"

# ERROR: libphidgets-0.6.15-1-r0 do_package_qa: QA Issue: non -dev/-dbg/nativesdk- package contains symlink .so: libphidgets path '/work/qemux86-webos-linux/libphidgets/0.6.15-1-r0/packages-split/libphidgets/usr/opt/ros/melodic/lib/libphidget21.so' [dev-so]
inherit ros_insane_dev_so
