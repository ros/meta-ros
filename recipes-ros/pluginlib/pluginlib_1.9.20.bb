DESCRIPTION = "\
The pluginlib package provides tools for writing and dynamically loading plugins using the ROS build infrastructure.\
To work, these tools require plugin providers to register their plugins in the package.xml of their package.\
"

SECTION = "devel"
LICENSE = "BSD & BSL-1.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=10;md5=bbbb6ab628b1f3daee74dd9c62bee312"

SRC_URI = "https://github.com/ros/${PN}/archive/${PV}.tar.gz;downloadfilename=${BP}.tar.gz"

SRC_URI[md5sum] = "0346edf3d399b3cdcbd96ee535585b31"
SRC_URI[sha256sum] = "6d1280b03f67666d128b98c478312d59b1eea0dd1e4233d268a565ce39ce5739"

DEPENDS = "boost class-loader rosconsole roslib libtinyxml"

inherit catkin
