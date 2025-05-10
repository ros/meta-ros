# Copyright (c) 2025 Wind River Systems, Inc.

inherit pkgconfig

EXTRA_OECMAKE += " \
    -DPROTOBUF_PROTOC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/protoc \
"

