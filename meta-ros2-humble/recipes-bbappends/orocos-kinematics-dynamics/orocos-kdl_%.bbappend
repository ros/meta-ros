# Copyright (c) 2019-2020 LG Electronics, Inc.
# Copyright (c) 2022 Acceleration Robotics S.L. <contact@accelerationrobotics.com>

LICENSE = "LGPL-2.1-or-later"

# ERROR: orocos-kdl-3.3.1-1-r0 do_package_qa: QA Issue: non -dev/-dbg/nativesdk- package contains symlink .so: orocos-kdl path '/work/aarch64-oe-linux/orocos-kdl/3.3.1-1-r0/packages-split/orocos-kdl/usr/lib/liborocos-kdl.so' [dev-so]
inherit ros_insane_dev_so

# ERROR: do_package: Files/directories were installed but not shipped in any package
#
FILES:${PN} += " ${datadir}/orocos_kdl/cmake"

