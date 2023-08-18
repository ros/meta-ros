inherit setuptools3-base

# |   Could not find a package configuration file provided by "rosidl_adapter"
# |   with any of the following names:
# |
# |     rosidl_adapterConfig.cmake
# |     rosidl_adapter-config.cmake

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-parser-native \
    rosidl-adapter-native \
    rosidl-typesupport-fastrtps-cpp-native \
    rosidl-typesupport-fastrtps-c-native \
    python3-numpy-native \
    python3-lark-parser-native \
    rpyutils-native \
"

ROS_BUILD_DEPENDS += " \
    rosidl-generator-c \
    rosidl-generator-cpp \
    rosidl-typesupport-c \
    rosidl-typesupport-cpp \
"
