# Copyright (c) 2019 LG Electronics, Inc.

# Force incorrectly classified ROS_EXEC_DEPENDS to be build dependencies:
DEPENDS_append := " ${ROS_EXEC_DEPENDS}"
ROS_EXEC_DEPENDS := ""
