# Copyright (c) 2020-2021 LG Electronics, Inc.

inherit ros_insane_dev_so python3targetconfig

DEPENDS += "python3-numpy-native"

EXTRA_OECMAKE += "-DPY_DEST=${PYTHON_SITEPACKAGES_DIR}"
