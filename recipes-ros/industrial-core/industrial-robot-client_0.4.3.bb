DESCRIPTION = "Ccontains generic clients for connecting to industrial robot controllers with servers that adhere to the simple message protocol"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "sensor-msgs control-msgs actionlib actionlib-msgs simple-message industrial-utils"

require industrial-core.inc

SRC_URI += " \
           file://0001-client-build-unit-tests-conditionally.patch \
           file://0001-industrial_robot_client-Fix-signature-of-goal-and-ca.patch \
           "

EXTRA_OECMAKE_append = "\
    -DCMAKE_FIND_ROOT_PATH_MODE_LIBRARY=NEVER \
    "
