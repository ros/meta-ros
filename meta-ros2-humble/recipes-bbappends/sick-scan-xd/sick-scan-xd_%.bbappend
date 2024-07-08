_LICENSE := "${LICENSE}"
LICENSE = "${@'${_LICENSE}'.replace('Apache-License,-Version-2.0,-see-"http-www.apache.org-licenses-LICENSE-2.0"', 'Apache-2.0')}"

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-adapter-native \
    rosidl-generator-c-native \
    rosidl-generator-cpp-native \
    rosidl-generator-py-native \
    rosidl-typesupport-fastrtps-c-native \
    rosidl-typesupport-fastrtps-cpp-native \
    rosidl-typesupport-introspection-cpp-native \
    rosidl-typesupport-cpp-native \
"
