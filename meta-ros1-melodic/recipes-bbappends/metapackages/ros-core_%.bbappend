# Copyright (c) 2019-2020 LG Electronics, Inc.

# core-* OE images do not support development.
ROS_EXEC_DEPENDS_remove = "cmake-modules"
ROS_EXEC_DEPENDS_remove = "gencpp"
ROS_EXEC_DEPENDS_remove = "geneus"
ROS_EXEC_DEPENDS_remove = "genlisp"
ROS_EXEC_DEPENDS_remove = "genmsg"
ROS_EXEC_DEPENDS_remove = "gennodejs"
ROS_EXEC_DEPENDS_remove = "genpy"
ROS_EXEC_DEPENDS_remove = "message-generation"

# The dependency on roslisp isn't mandatory and roslisp is blacklisted
ROS_EXEC_DEPENDS_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'lisp', 'geneus genlisp roslisp', '', d)}"
