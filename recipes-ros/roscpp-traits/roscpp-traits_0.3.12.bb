DESCRIPTION = "roscpp-traits contains the message traits code."
SECTION = "devel"
# TODO: License not mentioned in the file
LICENSE = "CLOSED"

## Problem: the filename 0.3.12.tar.gz of roscpp_traits clashes with the identical filename 0.3.12.tar.gz of rostime
## can we somehow influence the naming?
SRC_URI = "https://github.com/ros-gbp/roscpp_core-release/archive/release/roscpp_traits/0.3.12.tar.gz"
SRC_URI[md5sum] = "bf9d1ef41bb21a8ee1b2defa415cc0d8"
SRC_URI[sha256sum] = "f35cd1e29b50a2ffd89b36a9c919653ba2f6242c4b92618b544ded4f005ab912"

S = "${WORKDIR}/roscpp_core-release-release-roscpp_traits-0.3.12"

DEPENDS = "catkin-native"

inherit cmake pythonnative
