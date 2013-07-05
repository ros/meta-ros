DESCRIPTION = "\
The pluginlib package provides tools for writing and dynamically loading plugins using the ROS build infrastructure.\
To work, these tools require plugin providers to register their plugins in the package.xml of their package.\
"

SECTION = "devel"
LICENSE = "BSD & BSL-1.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=10;md5=bbbb6ab628b1f3daee74dd9c62bee312"

SRC_URI = "https://github.com/ros/${PN}/archive/${PV}.tar.gz;downloadfilename=${BP}.tar.gz;name=archive"
SRC_URI[archive.md5sum] = "64682c8e49434c333915fd0906fb4d84"
SRC_URI[archive.sha256sum] = "532d9358a8559effb3fabe57ac97ced8b5a61226251973f08f8901709d9591f7"

SRC_URI += "https://github.com/ros/pluginlib/commit/e71b89e00fbf56813266552b4d75fefe95e048f8.patch;name=patch"
SRC_URI[patch.md5sum] = "b9dcbfd4883edb947112b3a184c7a49b"
SRC_URI[patch.sha256sum] = "19c3d35de402309ed23b252db8493fb8a6d6abb34be6d88cbfd28b0e3e171016"

DEPENDS = "boost class-loader rosconsole roslib libtinyxml"

inherit catkin
