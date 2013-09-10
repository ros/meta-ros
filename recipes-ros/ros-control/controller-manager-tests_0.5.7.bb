DESCRIPTION = "Controller manager tests."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "rostest control-toolbox controller-interface controller-manager"

require ros-control.inc

SRC_URI += "file://0001-controller_manager_tests-CMakeLists-fix.patch;striplevel=2;name=patch"
SRC_URI[patch.md5sum] = "f1c884eed3ab9acc9e22d41de6d1cf3d"
SRC_URI[patch.sha256sum] = "fef01dd0d9fcd23626416593868dd7afa769c4f68412e5073181d7c619c4492c"
