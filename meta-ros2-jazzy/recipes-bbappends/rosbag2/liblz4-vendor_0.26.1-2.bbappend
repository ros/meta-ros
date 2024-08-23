#Copyright (c) 2024 Qualcomm Innovation Center, Inc. All rights reserved.

DEPENDS:remove = "${ROS_UNRESOLVED_DEP-liblz4-dev}"
RDEPENDS:${PN}:remove = "${ROS_UNRESOLVED_DEP-liblz4}"

DEPENDS:append = "lz4"
RDEPENDS:${PN}:append = "lz4"
