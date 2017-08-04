SUMMARY = ">A package containing builtin message and service definitions."
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=12c26a18c7f493fdc7e8a93b16b7c04f"
DEPENDS = " \
    rosidl-default-generators \
    rosidl-cmake \
    rosidl-parser \
    rosidl-generator-c \
    rosidl-generator-cpp \
    rosidl-generator-py \
    rmw-implementation-cmake \
    rmw \
    rmw-fastrtps-cpp \
    rosidl-typesupport-c \
    python-cmake-module \
"

include common-interfaces.inc
