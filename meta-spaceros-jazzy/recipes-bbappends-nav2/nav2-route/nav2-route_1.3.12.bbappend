# Copyright (c) 2026 Wind River Systems, Inc.

ROS_BUILD_DEPENDS:remove = "libnanoflann-dev"
ROS_EXPORT_DEPENDS:remove = "libnanoflann-dev"
ROS_EXEC_DEPENDS:remove = "libnanoflann-dev"

ROS_BUILD_DEPENDS:append = " nanoflann"

# ERROR: nav2-route-1.3.12-r0 do_package_qa: QA Issue: File /opt/ros/spaceros/share/nav2_route/cmake/export_nav2_routeExport.cmake in package nav2-route-dev contains reference to TMPDIR [buildpaths]
do_install:append() {
    sed -i -e "s#${RECIPE_SYSROOT}##g" ${D}${ros_prefix}/share/nav2_route/cmake/export_nav2_routeExport.cmake
}
