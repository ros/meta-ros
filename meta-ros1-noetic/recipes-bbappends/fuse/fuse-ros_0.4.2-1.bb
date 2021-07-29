require ../../generated-recipes/fuse/fuse_${PV}.bb

ROS_EXEC_DEPENDS_remove = "fuse-doc"
ROS_EXEC_DEPENDS += "fuse-ros-doc"
