DESCRIPTION = "Standalone Python library for generating ROS message and service data structures for various languages."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/ros/${BPN}/archive/${PV}.tar.gz;downloadfilename=${BP}.tar.gz \
           file://0001-modify-msg-file-handling-to-reference-them-relatively.patch \
           "

SRC_URI[md5sum] = "de385f1796bf025915ed7b20e1e1acc4"
SRC_URI[sha256sum] = "e510caa7692a4b0a0948688b9d2d8f6ff2f329980d7f78787276afec030806b7"

inherit  catkin 
