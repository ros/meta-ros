# Copyright (c) 2021 LG Electronics, Inc.

# used only as runtime dependency, but there is no ode/libode recipe, try to set it empty to test in runtime if this new dependency from 1.5.2 version is really mandatory
# https://github.com/ompl/ompl/compare/1.5.1...1.5.2
# https://github.com/ompl/ompl/commit/bb0a03c6fe4fbba0282c9a58881c3f499e7564d0 says it's optional
ROS_UNRESOLVED_DEP-opende = ""

# ERROR: ompl-1.5.2-1-r0 do_package: QA Issue: ompl: Files/directories were installed but not shipped in any package:
#   /usr/share/ament_index
#   /usr/share/ament_index/resource_index
#   /usr/share/ament_index/resource_index/packages
#   /usr/share/ament_index/resource_index/packages/ompl
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# ompl: 4 installed and not shipped files. [installed-vs-shipped]
#
# ros_ament_cmake.bbclass does this automatically, but this recipe inherits just ros_cmake.bbclass
FILES:${PN}:prepend = " \
    ${datadir}/ament_index \
"

# ERROR: ompl-1.5.2-1-r0 do_package_qa: QA Issue: non -dev/-dbg/nativesdk- package ompl contains symlink .so '/usr/lib/libompl.so' [dev-so]
inherit ros_insane_dev_so

# ERROR: ompl-1.5.2-1-r0 do_package_qa: QA Issue: ompl: /usr/lib/libompl.so.1.5.2 contains probably-redundant RPATH /usr/lib [useless-rpaths]
DEPENDS:append:class-target = " chrpath-replacement-native"
do_install:append() {
    chrpath --delete ${D}${libdir}/*${SOLIBS}
}

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-FindPython.cmake-install_python-Allow-to-set-differe.patch"

EXTRA_OECMAKE += "-DINSTALL_PYTHON_SHEBANG='/usr/bin/env python3'"
