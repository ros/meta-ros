# Copyright (c) 2021 LG Electronics, Inc.

# ERROR: srdfdom-0.6.2-1-r0 do_package: QA Issue: srdfdom: Files/directories were installed but not shipped in any package:
#   /usr/opt/ros/noetic/lib/libsrdfdom.so.0.6.2
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# srdfdom: 1 installed and not shipped files. [installed-vs-shipped]
FILES:${PN} += "${ros_libdir}/*${SOLIBS}"

# ERROR: srdfdom-0.6.2-1-r0 do_package_qa: QA Issue:
# non -dev/-dbg/nativesdk- package contains symlink .so: srdfdom path '/work/raspberrypi4-webos-linux-gnueabi/srdfdom/0.6.2-1-r0/packages-split/srdfdom/usr/opt/ros/noetic/lib/libsrdfdom.so' [dev-so]
inherit ros_insane_dev_so
