# Copyright (c) 2023 Wind River Systems, Inc.

# heaphook fails to link with:
#   libtlsf.a(tlsf.c.o): relocation R_X86_64_32S against `.rodata' can not be used when making a shared object; recompile with -fPIC
#   ld: failed to set dynamic section sizes: bad value
CFLAGS += "-fPIC"
