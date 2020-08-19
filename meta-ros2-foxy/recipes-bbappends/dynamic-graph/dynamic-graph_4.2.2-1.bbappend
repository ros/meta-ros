# Copyright (c) 2020 LG Electronics, Inc.

# WARNING: dynamic-graph-4.2.2-1-r0 do_package: QA Issue: dynamic-graph: Files/directories were installed but not shipped in any package:
#   /usr/lib/dynamic-graph-plugins/libtracer-real-time.so
#   /usr/lib/dynamic-graph-plugins/libtracer.so.4.2.2
#   /usr/lib/dynamic-graph-plugins/libtracer.so
#   /usr/lib/dynamic-graph-plugins/libtracer-real-time.so.4.2.2
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# dynamic-graph: 4 installed and not shipped files. [installed-vs-shipped]
FILES_${PN} += "${libdir}/dynamic-graph-plugins/lib*${SOLIBS}"
FILES_${PN}-dev += "${libdir}/dynamic-graph-plugins/lib*${SOLIBSDEV}"

# ERROR: dynamic-graph-4.2.2-1-r0 do_package_qa: QA Issue: non -dev/-dbg/nativesdk- package contains symlink .so: dynamic-graph path '/work/core2-64-oe-linux/dynamic-graph/4.2.2-1-r0/packages-split/dynamic-graph/usr/lib/libdynamic-graph.so' [dev-so]
# ERROR: dynamic-graph-4.2.2-1-r0 do_package_qa: QA run found fatal errors. Please consider fixing them.
inherit ros_insane_dev_so
