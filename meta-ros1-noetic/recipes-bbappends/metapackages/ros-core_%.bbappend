# Copyright (c) 2019-2020 LG Electronics, Inc.

# core-* OE images do not support development.
ROS_EXEC_DEPENDS:remove = "cmake-modules"
ROS_EXEC_DEPENDS:remove = "gencpp"
ROS_EXEC_DEPENDS:remove = "geneus"
ROS_EXEC_DEPENDS:remove = "genlisp"
ROS_EXEC_DEPENDS:remove = "genmsg"
ROS_EXEC_DEPENDS:remove = "gennodejs"
ROS_EXEC_DEPENDS:remove = "genpy"
ROS_EXEC_DEPENDS:remove = "message-generation"

# The dependency on roslisp isn't mandatory and roslisp is blacklisted
ROS_EXEC_DEPENDS:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'lisp', 'geneus genlisp roslisp', '', d)}"
