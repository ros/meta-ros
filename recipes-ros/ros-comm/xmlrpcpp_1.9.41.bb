DESCRIPTION = \
  "XmlRpc++ is a C++ implementation of the XML-RPC protocol. This version is \
    heavily modified from the package available on SourceForge in order to \
    support roscpp's threading model. As such, we are maintaining our \
    own fork."
SECTION = "devel"
LICENSE = "LGPL"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=46ee8693f40a89a31023e97ae17ecf19"

SRC_URI = "https://github.com/ros-gbp/ros_comm-release/archive/release/xmlrpcpp/1.9.41.tar.gz;downloadfilename=xmlrpcpp_1.9.41.tar.gz"
SRC_URI[md5sum] = "036a6544a574faca48c52489e6767530"
SRC_URI[sha256sum] = "1e3ced256ecbbd05f0c1821ce99c33127cbdd5284e4b789bced55508f2581c48"

S = "${WORKDIR}/ros_comm-release-release-xmlrpcpp-1.9.41"

DEPENDS = "catkin-native cpp-common"

FILES_${PN} += "${libdir}/*"

inherit distutils cmake pythonnative

EXTRA_OECMAKE = " \
  -Dcpp_common_DIR=${STAGING_DATADIR}/cpp_common/cmake/ \
  "

