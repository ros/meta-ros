# Copyright (c) 2020 LG Electronics, Inc.

ROS_BUILD_DEPENDS += " \
    libglu \
"

# WARNING: stage-4.3.0-r0 do_package: QA Issue: stage: Files/directories were installed but not shipped in any package:
#  /usr/lib/Stage-4.3/expand_swarm.so
#  /usr/lib/Stage-4.3/pioneer_flocking.so
#  /usr/lib/Stage-4.3/fasr2.so
#  /usr/lib/Stage-4.3/expand_pioneer.so
#  /usr/lib/Stage-4.3/dynamic.so
#  /usr/lib/Stage-4.3/wander.so
#  /usr/lib/Stage-4.3/source.so
#  /usr/lib/Stage-4.3/lasernoise.so
#  /usr/lib/Stage-4.3/rasterize.so
#  /usr/lib/Stage-4.3/fasr.so
#  /usr/lib/Stage-4.3/sink.so
#Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
#stage: 11 installed and not shipped files. [installed-vs-shipped]
FILES_${PN} += "${libdir}/Stage-4.3"

# ERROR: stage-4.3.0-r0 do_package_qa: QA Issue: non -dev/-dbg/nativesdk- package contains symlink .so: stage path '/work/core2-64-oe-linux/stage/4.3.0-r0/packages-split/stage/usr/lib/libstage.so' [dev-so]
inherit ros_insane_dev_so
