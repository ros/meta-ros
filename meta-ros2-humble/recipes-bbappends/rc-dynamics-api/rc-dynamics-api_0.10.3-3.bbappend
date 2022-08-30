ROS_BUILDTOOL_DEPENDS:append = " \
    protobuf-native \
"

#fix qa [dev-so]
FILES:${PN}-dev += " \
    ${libdir}/*.so \
"