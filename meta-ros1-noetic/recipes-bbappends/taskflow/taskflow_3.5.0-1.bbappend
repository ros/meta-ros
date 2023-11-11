# Copyright (c) 2021 LG Electronics, Inc.

# It builds tests with target toolchain, but then tries to run them on host system
EXTRA_OECMAKE += "-DTF_BUILD_TESTS=OFF"
