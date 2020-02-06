# Copyright (c) 2019-2020 LG Electronics, Inc.

# Not supporting Lisp => remove dependencies on geneus and genlisp
do_configure_prepend() {
    sed -i -e '/^catkin_package(/ {; s/ geneus / /; s/ genlisp / /; }' ${S}/CMakeLists.txt
}

ROS_EXPORT_DEPENDS_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'lisp', 'geneus genlisp', '', d)}"
ROS_EXEC_DEPENDS_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'lisp', 'geneus genlisp', '', d)}"
