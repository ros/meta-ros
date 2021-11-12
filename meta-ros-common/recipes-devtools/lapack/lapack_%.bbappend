# Copyright (c) 2021 LG Electronics, Inc.

# enable cblas
EXTRA_OECMAKE += "-DCBLAS=ON"

# fix configure error during FortranCInterface detect
OECMAKE_FIND_ROOT_PATH_MODE_PROGRAM = "BOTH"

# We were using openblas recipe to build cblas
PROVIDES += "openblas"
