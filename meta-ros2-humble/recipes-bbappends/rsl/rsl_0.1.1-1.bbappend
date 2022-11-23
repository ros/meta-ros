# Copyright (c) 2022 LG Electronics, Inc.

# apex-containers/0.0.4-2-r0/git/include/string/base_string.hpp:453:46: error: conversion from 'size64_t' {aka 'long long unsigned int'} to 'size_t' {aka 'unsigned int'} may change value [-Werror=conversion]
# apex-containers/0.0.4-2-r0/git/include/string/base_string.hpp:52:67: error: conversion from 'size64_t' {aka 'long long unsigned int'} to 'size_t' {aka 'unsigned int'} may change value [-Werror=conversion]
# apex-containers/0.0.4-2-r0/git/include/string/string_silent.hpp:185:67: error: conversion from 'size64_t' {aka 'long long unsigned int'} to 'size_t' {aka 'unsigned int'} may change value [-Werror=conversion]
# apex-containers/0.0.4-2-r0/git/include/string/string_silent.hpp:195:67: error: conversion from 'size64_t' {aka 'long long unsigned int'} to 'size_t' {aka 'unsigned int'} may change value [-Werror=conversion]
# apex-containers/0.0.4-2-r0/git/include/string/string_silent.hpp:204:67: error: conversion from 'size64_t' {aka 'long long unsigned int'} to 'size_t' {aka 'unsigned int'} may change value [-Werror=conversion]
# apex-containers/0.0.4-2-r0/git/include/string/string_silent.hpp:76:70: error: conversion from 'size64_t' {aka 'long long unsigned int'} to 'size_t' {aka 'unsigned int'} may change value [-Werror=conversion]
# apex-containers/0.0.4-2-r0/git/include/string/string_silent.hpp:81:62: error: conversion from 'size64_t' {aka 'long long unsigned int'} to 'size_t' {aka 'unsigned int'} may change value [-Werror=conversion]
# apex-containers/0.0.4-2-r0/git/src/apex_string.c:233:52: error: conversion from 'size64_t' {aka 'long long unsigned int'} to 'size_t' {aka 'unsigned int'} may change value [-Werror=conversion]
# apex-containers/0.0.4-2-r0/git/src/apex_string.c:48:38: error: conversion from 'size64_t' {aka 'long long unsigned int'} to 'size_t' {aka 'unsigned int'} may change value [-Werror=conversion]
CFLAGS += "-Wno-error=sign-conversion -Wno-error=old-style-cast"
CXXFLAGS += "-Wno-error=sign-conversion -Wno-error=old-style-cast"
