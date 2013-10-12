DESCRIPTION = "Xacro is an XML macro language."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "32848b03f52b6a4b4040ccc4634c13ce"
SRC_URI[sha256sum] = "44f7190cecab31ab67460d40c7872d99fe89907fad20106dbf5205f33ba54718"

SRC_URI += "file://0001-check-for-CATKIN_ENABLE_TESTING.patch"

inherit catkin
