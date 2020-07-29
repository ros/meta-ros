# Copyright (c) 2020 LG Electronics, Inc.

# In function 'strncpy',
#    inlined from 'oshw_find_adapters' at webos-melodic-zeus/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/soem/1.4.0-1-r0/git/SOEM/oshw/linux/oshw.c:83:11:
# webos-melodic-zeus/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/soem/1.4.0-1-r0/recipe-sysroot/usr/include/bits/string_fortified.h:106:10: error: '__builtin___strncpy_chk' specified bound depends on the length of the source argument [-Werror=stringop-overflow=]
#   106 |   return __builtin___strncpy_chk (__dest, __src, __len, __bos (__dest));
#       |          ^~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
CFLAGS += "-Wno-error=stringop-overflow="
