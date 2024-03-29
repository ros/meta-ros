# rmw-dds-common rightfully RDEPENDS on rosidl-default-runtime.
# but because it is ament_export_dependencies, it will not get found
# otherwise later down the road. 

DEPENDS:append = " \
    rosidl-default-runtime \
"
