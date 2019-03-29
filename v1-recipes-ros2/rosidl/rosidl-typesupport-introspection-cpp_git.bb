SUMMARY = "Generate the message type support for dynamic message construction in C++."
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=12c26a18c7f493fdc7e8a93b16b7c04f"
DEPENDS = "rosidl-cmake rosidl-generator-c rosidl-typesupport-introspection-c"

include rosidl.inc

RDEPENDS_${PN} = " \
    rosidl-cmake \
    rosidl-generator-c \
    rosidl-generator-cpp \
    rosidl-parser \
    rosidl-typesupport-interface \
    rosidl-typesupport-introspection-c \
"
