# geographiclib-tools is just a package from geographiclib recipe it should be in
# RDEPENDS not DEPENDS
ROS_BUILD_DEPENDS_remove = "${ROS_UNRESOLVED_PLATFORM_PKG_geographiclib-tools}"
ROS_EXPORT_DEPENDS_remove = "${ROS_UNRESOLVED_PLATFORM_PKG_geographiclib-tools}"
