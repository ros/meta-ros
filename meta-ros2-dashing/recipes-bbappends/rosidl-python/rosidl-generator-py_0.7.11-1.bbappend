# Copyright (c) 2019 LG Electronics, Inc.

ROS_EXPORT_DEPENDS += " \
    python3-numpy \
"

# NB. RECIPE_SYSROOT_NATIVE doesn't exist in [morty].
export RECIPE_SYSROOT_NATIVE
do_install:append() {
    # - Add <NATIVE-SYSROOT>/<PYTHON-SITE-PACKAGES>/numpy/core/include to the include file search path. XXX Why doesn't this need
    #   to be done under Ubuntu bionic?
    # - HACK: Why can't I find a CMake variable containing the native sysroot that could be used instead of ${CMAKE_ROOT}/../..?
    # - Use [{] and [}] to prevent bitbake from attempting to expand ${CMAKE_CURRENT_BINARY_DIR} in the regex. Can't use this
    #   trick in the substituted text, so instead, translate < > to { }.
    sed -i -e '/target_include_directories([^)]*$/,/)/ { ;
                    s@\$[{]CMAKE_CURRENT_BINARY_DIR[}]/rosidl_generator_py@& $<CMAKE_ROOT>/../../$<PYTHON_INSTALL_DIR>/numpy/core/include@ ;
                    y/<>/{}/ ;
               }' ${D}${datadir}/${ROS_BPN}/cmake/rosidl_generator_py_generate_interfaces.cmake
}
