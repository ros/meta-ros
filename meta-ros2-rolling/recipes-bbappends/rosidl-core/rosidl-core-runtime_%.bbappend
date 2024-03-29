FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " \
    file://0001-Added-Python3-to-rosidl-core-runtime.patch \
"

BBCLASSEXTEND = "native"

DEPENDS:append = " \
    python3-numpy-native \
"

RDEPENDS:${PN} += " \
    rosidl-runtime-c \
    rosidl-runtime-cpp \
    rosidl-generator-py \
    rosidl-typesupport-c \
    rosidl-typesupport-fastrtps-c \
    rosidl-typesupport-introspection-c \
    rosidl-typesupport-cpp \
    rosidl-typesupport-fastrtps-cpp \
    rosidl-typesupport-introspection-cpp \
"
