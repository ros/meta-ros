CXXFLAGS += "-Wno-error=format-security -Wno-error=unused-parameter"

ROS_BUILDTOOL_DEPENDS += "rclcpp-components"

# Fix to remove TMPDIR from Export.cmake
do_install:append() {
    sed -i -e "s#${RECIPE_SYSROOT}[^;]*;##g" ${D}${ros_datadir}/${ROS_BPN}/cmake/export_${ROS_BPN}Export.cmake
    sed -i -e 's#${RECIPE_SYSROOT}[^"]*##g' ${D}${ros_datadir}/${ROS_BPN}/cmake/export_${ROS_BPN}Export.cmake
}
