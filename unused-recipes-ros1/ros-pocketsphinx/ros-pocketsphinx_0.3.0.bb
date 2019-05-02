DESCRIPTION = "This package is a simple wrapper around the pocketsphinx speech recognizer, \
using gstreamer and a Python-based interface."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/mikeferguson/pocketsphinx/archive/${PV}.tar.gz;downloadfilename=${PN}.tar.gz"
SRC_URI[md5sum] = "814912c0fa4e28dee0e7abc2576f1ad2"
SRC_URI[sha256sum] = "79aed79079d1ca4ac470ea55a82c1de13473df29187b7e8ecec86969c253284a"

S = "${WORKDIR}/pocketsphinx-${PV}"

inherit catkin

do_configure_prepend () {
    #rename pocketsphinx to ros_pocketsphinx, to avoid collision with original pocketsphinx
    sed -i 's:project(pocketsphinx):project(${ROS_SPN}):g' ${S}/CMakeLists.txt
    sed -i 's:<name>pocketsphinx</name>:<name>${ROS_SPN}</name>:g' ${S}/package.xml
    sed -i "s:load_manifest('pocketsphinx'):load_manifest('${ROS_SPN}'):g" ${S}/nodes/*py
    sed -i 's:pkg="pocketsphinx:pkg="${ROS_SPN}:g' ${S}/demo/*launch
    sed -i 's:find pocketsphinx:find ${ROS_SPN}:g' ${S}/demo/*launch
}

RDEPENDS_${PN} = "std-srvs rospy gstreamer0.10-pocketsphinx"

#provides gconfaudiosrc, used to find name of microphone
RRECOMMENDS_${PN} += "gst-plugins-good-gconfelements"

ROS_SPN = "ros_pocketsphinx"
