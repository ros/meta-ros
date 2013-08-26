DESCRIPTION = "\
The pluginlib package provides tools for writing and dynamically loading plugins using the ROS build infrastructure.\
To work, these tools require plugin providers to register their plugins in the package.xml of their package.\
"
SECTION = "devel"
LICENSE = "BSD & BSL-1.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=10;md5=bbbb6ab628b1f3daee74dd9c62bee312"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "0326d9e5b53c21cf6491cfc29bedaac6"
SRC_URI[sha256sum] = "78cf6ac7149ea9257ef85f2038fd29f069be76f7db8b1e068ab162739e3b02ac"

DEPENDS = "boost class-loader rosconsole roslib libtinyxml"

inherit catkin
