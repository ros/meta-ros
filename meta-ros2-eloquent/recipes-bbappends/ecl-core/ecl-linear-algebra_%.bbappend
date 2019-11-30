# Copyright (c) 2019 LG Electronics, Inc.

inherit ros-insane

# sophus PN is empty, so it wasn't created
RDEPENDS_${PN}_remove = "sophus"
