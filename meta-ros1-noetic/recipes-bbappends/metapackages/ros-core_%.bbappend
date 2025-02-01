# Copyright (c) 2019-2020 LG Electronics, Inc.

# The dependency on roslisp isn't mandatory and roslisp is blacklisted
ROS_EXEC_DEPENDS:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'lisp', 'geneus genlisp roslisp', '', d)}"
