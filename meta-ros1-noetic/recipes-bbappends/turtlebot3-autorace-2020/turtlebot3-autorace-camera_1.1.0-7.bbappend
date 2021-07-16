# Copyright (c) 2021 LG Electronics, Inc.

# oldest supported OE release dunfell has python3-3.8 so we don't need this backport from 3.4
ROS_EXEC_DEPENDS:remove = "${PYTHON_PN}-enum34"
