# Copyright (c) 2020 LG Electronics, Inc.

inherit ros_insane_dev_so

# sophus PN is empty, so it wasn't created
RDEPENDS:${PN}:remove = "sophus"
