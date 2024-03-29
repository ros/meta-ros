ROS_BUILD_DEPENDS += " \
    python3-numpy \
"
ROS_EXPORT_DEPENDS += " \
    python3-numpy \
    rosidl-generator-c \
    rosidl-typesupport-c \
    rosidl-typesupport-cpp \
    rosidl-typesupport-fastrtps-c \
    rosidl-typesupport-fastrtps-cpp \
"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI:append = " \
     file://0001-rosidl_generator_py_generate_interfaces-use-cmake-ta.patch \
"
