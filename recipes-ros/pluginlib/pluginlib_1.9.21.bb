DESCRIPTION = "\
The pluginlib package provides tools for writing and dynamically loading plugins using the ROS build infrastructure.\
To work, these tools require plugin providers to register their plugins in the package.xml of their package.\
"

SECTION = "devel"
LICENSE = "BSD & BSL-1.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=10;md5=bbbb6ab628b1f3daee74dd9c62bee312"

SRC_URI = "https://github.com/ros/${PN}/archive/${PV}.tar.gz;downloadfilename=${BP}.tar.gz"
SRC_URI[md5sum] = "c506945693bc53e60600a849275e4a98"
SRC_URI[sha256sum] = "a8c5aa266a27810c39a2ced76d531358880c7728a948f7e7a8972b70ed42a425"

DEPENDS = "boost class-loader rosconsole roslib libtinyxml"

inherit catkin
