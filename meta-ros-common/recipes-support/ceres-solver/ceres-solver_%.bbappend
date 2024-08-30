# Copyright (c) 2019-2021 LG Electronics, Inc.

PACKAGECONFIG ??= "suitesparse cxsparse lapack"

EXTRA_OECMAKE += " -DEIGENSPARSE:BOOL=OFF"
