DESCRIPTION = "Python ROS message and service generators."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "genmsg-native"
RDEPENDS_${PN} = "python-math genmsg python-shell"
RDEPENDS_${PN}_class-native = ""

PR = "r1"

SRC_URI = "https://github.com/ros/${BPN}/archive/${PV}.tar.gz;downloadfilename=${BP}.tar.gz \
           file://0001-genpy-extras.cmake.em-use-find_program-for-GENxxx_PY_BIN.patch"
SRC_URI[md5sum] = "23915e68167ba6d58c65920bfabd2fad"
SRC_URI[sha256sum] = "6c77bde606c9637b0fa9e6f4ed85882e98547500a7472d2643bcc52b6c8a8b78"

inherit catkin
