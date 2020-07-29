# Copyright (c) 2020 LG Electronics, Inc.

# The dependency on roslisp isn't mandatory and roslisp is blacklisted
ROS_EXPORT_DEPENDS_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'lisp', 'roslisp', '', d)}"
ROS_EXEC_DEPENDS_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'lisp', 'roslisp', '', d)}"
