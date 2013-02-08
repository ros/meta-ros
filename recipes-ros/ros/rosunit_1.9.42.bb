DESCRIPTION = "Unit-testing package for ROS. This is a lower-level library for rostest and handles unit tests, whereas rostest handles integration tests."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/ros-gbp/ros-release/archive/release/rosunit/1.9.42.tar.gz;downloadfilename=rosunit_1.9.42.tar.gz"
SRC_URI[md5sum] = "1ddf9898fdde848e7ccaea88abb62296"
SRC_URI[sha256sum] = "65ef24469c572f5b4105b95db3830a565e0de71f8f9c8982ecf80b3244ca9a33"

S = "${WORKDIR}/ros-release-release-rosunit-1.9.42"

DEPENDS = "catkin-native"

FILES_${PN} += "${libdir}/*"

inherit cmake pythonnative

EXTRA_OECMAKE = " \
  "

export BUILD_SYS
export HOST_SYS
export STAGING_LIBDIR
export STAGING_INCDIR

