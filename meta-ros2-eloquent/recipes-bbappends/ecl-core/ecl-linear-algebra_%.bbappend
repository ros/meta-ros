# Copyright (c) 2019 LG Electronics, Inc.

inherit ros_insane_dev_so

# sophus PN is empty, so it wasn't created
RDEPENDS_${PN}_remove = "sophus"
