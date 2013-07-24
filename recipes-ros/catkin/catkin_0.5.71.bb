DESCRIPTION = "Low-level build system macros and infrastructure for ROS"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "cmake python-empy python-catkin-pkg python-empy-native python-catkin-pkg-native"
RDEPENDS_${PN}_class-native = ""

RDEPENDS_${PN} = "cmake make binutils binutils-symlinks gcc gcc-symlinks g++ g++-symlinks \
    python-catkin-pkg python-argparse python-misc python-multiprocessing \
    python-shell python-subprocess python-xml"

SRC_URI = "https://github.com/ros/catkin/archive/${PV}.tar.gz;downloadfilename={ROS_BP}.tar.gz \
           file://0001-CATKIN_WORKSPACES-Don-t-require-.catkin-file.patch \
           "
SRC_URI[md5sum] = "1c30ac4fcc82ce2aedf610ea972ab4d2"
SRC_URI[sha256sum] = "2494dbe3446fe94a55f57c74260e072f97d72944d89610fe4994dbc79cf1a561"

inherit catkin

FILES_${PN}-dev += "\
    ${datadir}/eigen/cmake \
    ${datadir}/ros/cmake \
    ${prefix}/.catkin \
    ${prefix}/.rosinstall \
    ${prefix}/_setup_util.py \
    ${prefix}/env.sh \
    ${prefix}/setup.* \
    "

BBCLASSEXTEND += "native"
