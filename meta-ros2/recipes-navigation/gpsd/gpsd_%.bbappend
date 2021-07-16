# Copyright (c) 2019 LG Electronics, Inc.

# All ROS2 distros are python3-only and blacklist python2
DEPENDS:remove = "python"

RDEPENDS:python-pygps:remove = " \
    python-core \
    python-curses \
    python-io \
    python-threading \
    python-terminal \
    gpsd \
    python-json \
"
