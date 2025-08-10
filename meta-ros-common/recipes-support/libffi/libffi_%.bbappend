# Copyright (c) 2025 Wind River Systems, Inc.

# The libffi.a static library is built by default without -fPIC set.
# This causes an error when openmp builds libomptarget.so.
# A recent change to openmp prioritizes using libffi.a over libffi.so
# this causes libomptarget to fail to link against libffi.a
EXTRA_OECONF += " --with-pic"
