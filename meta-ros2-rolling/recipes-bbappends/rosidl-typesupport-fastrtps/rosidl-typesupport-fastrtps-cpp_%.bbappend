# Even though, we correctly RDEPEND on rosidl-generator-cpp, we
# ament_export_dependency it so we need to DEPEND on it so it gets
# found later down the road

DEPENDS:append = " \
    rosidl-generator-cpp \
"
