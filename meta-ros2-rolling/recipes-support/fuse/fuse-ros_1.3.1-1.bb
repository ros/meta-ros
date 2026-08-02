require ../../generated-recipes/fuse/fuse_${PV}.bb

LICENSE = "BSD-3-Clause"

ROS_EXEC_DEPENDS:remove = "fuse-doc"
ROS_EXEC_DEPENDS += "fuse-doc-ros"
