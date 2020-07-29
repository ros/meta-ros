# Copyright (c) 2020 LG Electronics, Inc.

# Fails with webOS OSE which by default uses -Werror=return-type
# microstrain-mips/0.0.3-1-r0/git/include/microstrain_mips/microstrain_3dm.h:94:24: error: control reaches end of non-void function [-Werror=return-type]
# microstrain-mips/0.0.3-1-r0/git/src/microstrain_3dm.cpp:3135:3: error: control reaches end of non-void function [-Werror=return-type]
CXXFLAGS += "-Wno-error=return-type"

# Don't use -Wformat-security
# because the flags from CMakeLists.txt:
# set(CMAKE_C_FLAGS "-Wno-implicit-function-declaration -Wno-incompatible-pointer-types -Wno-format -fno-builtin-memcpy")
# add -Wno-format, which breaks -Wformat-security:
# cc1: error: -Wformat-security ignored without -Wformat [-Werror=format-security]
SECURITY_STRINGFORMAT = ""

do_configure_prepend() {
    # Respect default CMAKE_C_FLAGS (e.g. -mfloat-abi=hard)
    sed 's#set(CMAKE_C_FLAGS "-Wno#set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -Wno#g' -i ${S}/CMakeLists.txt
}
