DESCRIPTION = "\
console_bridge is a ROS-independent, pure CMake package that provides logging \
calls that mirror those found in rosconsole, but for applications that are \
not necessarily using ROS.\
"

SECTION = "devel"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "\
  file://include/console_bridge/console.h;beginline=1;endline=33;md5=279eed49072cc9f6ebe38974afcc4803 \
  file://src/console.cpp;beginline=1;endline=33;md5=279eed49072cc9f6ebe38974afcc4803 \
"

DEPENDS = "boost"

SRC_URI = "https://github.com/ros/console_bridge/archive/${PV}.tar.gz;downloadfilename=${BP}.tar.gz"
SRC_URI[md5sum] = "82c24b68ffaacee540055571669dcdd7"
SRC_URI[sha256sum] = "69c3efa4ef86b2c3ffb37d29a9c6169853975a3bc362815c9cffc40f74b25f18"

S = "${WORKDIR}/console_bridge-${PV}"

inherit cmake

FILES_SOLIBSDEV = ""
FILES_${PN} += "${libdir}/lib*${SOLIBSDEV}"

