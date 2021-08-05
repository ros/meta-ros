# Copyright (c) 2019-2020 LG Electronics, Inc.

# Not supporting Lisp => remove dependencies on geneus and genlisp
do_configure:prepend() {
    sed -i -e '/^catkin_package(/ {; s/ geneus / /; s/ genlisp / /; }' ${S}/CMakeLists.txt
}

ROS_EXPORT_DEPENDS:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'lisp', 'geneus genlisp', '', d)}"
ROS_EXEC_DEPENDS:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'lisp', 'geneus genlisp', '', d)}"

# These aren't available for native build
ROS_EXPORT_DEPENDS:remove:class-native = "gencpp geneus genlisp gennodejs genpy"
ROS_EXEC_DEPENDS:remove:class-native = "gencpp geneus genlisp gennodejs genpy"
