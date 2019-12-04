# Copyright (c) 2019 LG Electronics, Inc.

# Not supporting Lisp => remove dependencies on geneus and genlisp
do_configure_prepend() {
    sed -i -e '/^catkin_package(/ {; s/ geneus / /; s/ genlisp / /; }' ${S}/CMakeLists.txt
}
