DESCRIPTION = "Low-level build system macros and infrastructure for ROS"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/ros/catkin/archive/0.5.58.tar.gz;downloadfile=catkin_0.5.58.tar.gz \
  file://catkin-change_default_for_debsetuptools.patch \
  file://catkin-remove_assertion_for_rt_library.patch \
"
SRC_URI[md5sum] = "e4df85e60dc792af9324334547cc76aa"
SRC_URI[sha256sum] = "dd99cc04eeaf16a13185dd0a2f576939fa997dfb16a40ba45068c4d2ebbcb44b"

# DEPENDS = "python-setuptools"
DEPENDS = "python-empy-native python-catkin-pkg-native python"

EXTRA_OECMAKE = "-DSETUPTOOLS_DEB_LAYOUT=OFF"

BBCLASSEXTEND += "native"
inherit cmake pythonnative python-dir

FILES_${PN} += "${libdir}/${PYTHON_DIR}/* ${PYTHON_SITEPACKAGES_DIR}/*"
# FILES_${PN}-dev += "${libdir}/${PYTHON_DIR}/* ${PYTHON_SITEPACKAGES_DIR}/*"

export BUILD_SYS
export HOST_SYS
export STAGING_LIBDIR
export STAGING_INCDIR

