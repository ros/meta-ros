SUMMARY = "A configuration package defining the default ROS interface generators."
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

include rosidl-typesupport.inc

# TODO: add missing 'buildtool_export_depend' values from package.xml
RDEPENDS_${PN}-dev += " \
    rosidl-generator-c \
    rosidl-generator-cpp \
    rosidl-generator-py \
    rosidl-typesupport-c \
    rosidl-typesupport-cpp \
    rosidl-typesupport-introspection-c \
    rosidl-typesupport-introspection-cpp \
"
