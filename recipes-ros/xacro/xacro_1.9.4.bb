DESCRIPTION = "Xacro is an XML macro language."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "roslint"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "9ca1e5230a61e28cc4e65132f0b48da9"
SRC_URI[sha256sum] = "bb3da8ab5cea943c810c3473203c59c78dad7f85204d0a13243d225dcedff240"

inherit catkin
