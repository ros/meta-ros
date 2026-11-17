# CMake package configuration for the system libyaml (oe-core's autotools build
# installs only a pkg-config file, which makes consumers embed absolute sysroot
# paths into their own exported CMake files).
#
# Defines the imported target "yaml" and the variables yaml_LIBRARIES and
# yaml_INCLUDE_DIRS. All paths are computed from this file's location, never
# hard-coded, so the file is relocatable. It is installed in
# <libdir>/cmake/yaml, so <libdir> is two levels up and <prefix> three.

get_filename_component(_yaml_libdir "${CMAKE_CURRENT_LIST_DIR}/../.." ABSOLUTE)
get_filename_component(_yaml_prefix "${CMAKE_CURRENT_LIST_DIR}/../../.." ABSOLUTE)

if(NOT TARGET yaml)
  add_library(yaml SHARED IMPORTED)
  set_target_properties(yaml PROPERTIES
    IMPORTED_LOCATION "${_yaml_libdir}/libyaml${CMAKE_SHARED_LIBRARY_SUFFIX}"
    INTERFACE_INCLUDE_DIRECTORIES "${_yaml_prefix}/include"
  )
endif()

set(yaml_LIBRARIES yaml)
set(yaml_INCLUDE_DIRS "${_yaml_prefix}/include")

unset(_yaml_libdir)
unset(_yaml_prefix)
