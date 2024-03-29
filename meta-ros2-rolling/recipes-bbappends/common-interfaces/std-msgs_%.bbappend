# std-msgs really only RDEPENDS on rosidl-default-runtime, but
# ament_export_dependencies it. Therefore, depending packages would
# fail when looking for it in cmake configure step. 

DEPENDS:append = " \
    rosidl-default-runtime \
"
