SUMMARY = "A configuration package defining the runtime for the ROS interfaces."
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

include rosidl-typesupport.inc

RDEPENDS_${PN}-dev += " \
    rosidl-generator-cpp-dev \
    rosidl-generator-py-dev \
    rosidl-typesupport-c-dev \
    rosidl-typesupport-cpp-dev \
    rosidl-typesupport-introspection-c-dev \
    rosidl-typesupport-introspection-cpp-dev \
"
