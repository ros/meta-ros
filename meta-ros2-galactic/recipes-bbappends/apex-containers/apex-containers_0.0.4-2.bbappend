# Copyright (c) 2021 LG Electronics, Inc.

# apex-containers/0.0.4-2-r0/git/include/string/base_string.hpp:453:46: error: conversion from 'size64_t' {aka 'long long unsigned int'} to 'size_t' {aka 'unsigned int'} may change value [-Werror=conversion]
# apex-containers/0.0.4-2-r0/git/include/string/base_string.hpp:52:67: error: conversion from 'size64_t' {aka 'long long unsigned int'} to 'size_t' {aka 'unsigned int'} may change value [-Werror=conversion]
# apex-containers/0.0.4-2-r0/git/include/string/string_silent.hpp:185:67: error: conversion from 'size64_t' {aka 'long long unsigned int'} to 'size_t' {aka 'unsigned int'} may change value [-Werror=conversion]
# apex-containers/0.0.4-2-r0/git/include/string/string_silent.hpp:195:67: error: conversion from 'size64_t' {aka 'long long unsigned int'} to 'size_t' {aka 'unsigned int'} may change value [-Werror=conversion]
# apex-containers/0.0.4-2-r0/git/include/string/string_silent.hpp:204:67: error: conversion from 'size64_t' {aka 'long long unsigned int'} to 'size_t' {aka 'unsigned int'} may change value [-Werror=conversion]
# apex-containers/0.0.4-2-r0/git/include/string/string_silent.hpp:76:70: error: conversion from 'size64_t' {aka 'long long unsigned int'} to 'size_t' {aka 'unsigned int'} may change value [-Werror=conversion]
# apex-containers/0.0.4-2-r0/git/include/string/string_silent.hpp:81:62: error: conversion from 'size64_t' {aka 'long long unsigned int'} to 'size_t' {aka 'unsigned int'} may change value [-Werror=conversion]
# apex-containers/0.0.4-2-r0/git/src/apex_string.c:233:52: error: conversion from 'size64_t' {aka 'long long unsigned int'} to 'size_t' {aka 'unsigned int'} may change value [-Werror=conversion]
# apex-containers/0.0.4-2-r0/git/src/apex_string.c:48:38: error: conversion from 'size64_t' {aka 'long long unsigned int'} to 'size_t' {aka 'unsigned int'} may change value [-Werror=conversion]
CFLAGS += "-Wno-error=conversion"
CXXFLAGS += "-Wno-error=conversion"

# apex-containers/0.0.4-2-r0/git/include/string/string_silent.hpp:76:50: error: 'size_t strnlen(const char*, size_t)' specified bound 31 exceeds source size 16 [-Werror=stringop-overread]
# apex-containers/0.0.4-2-r0/git/include/string/string_silent.hpp:76:50: error: 'size_t strnlen(const char*, size_t)' specified bound 7 may exceed source size 6 [-Werror=stringop-overread]
SRC_URI += "file://0002-string_silent.hpp-fix-stringop-overread-issue.patch"

# apex-containers/0.0.4-2-r0/git/src/string/to_string.cpp:341:18: error: redefinition of 'apex::string32_t apex::to_string(uint64_t)'
# apex-containers/0.0.4-2-r0/git/src/string/to_string.cpp:399:18: error: redefinition of 'apex::string32_t apex::to_string(int64_t)'
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-to_string.hpp-remove-inline-version-of-apex-to_strin.patch"
