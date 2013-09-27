DESCRIPTION = "This package retrieves data from url-format files such as http://, ftp://, package:// file://, etc., and loads the data into memory. The package:// url for ros packages is translated into a local file:// url.  The resourse retriever was initially designed to load mesh files into memory, but it can be used for any type of data. The resource retriever is based on the the libcurl library."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=16;endline=16;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "curl rosconsole roslib"

require robot-model.inc

SRC_URI += "file://0001-resource_retriever-test-CMakeLists.txt-fix.patch;striplevel=2"

