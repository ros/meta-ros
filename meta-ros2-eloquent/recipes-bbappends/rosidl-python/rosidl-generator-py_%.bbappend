# Copyright (c) 2020 LG Electronics, Inc.

# work around a limitation in OE thud that native recipes
# don't follow the RDEPENDS set in the recipe until this
# commit in warrior:
# http://git.openembedded.org/openembedded-core/commit/?id=c62520b63284927e177831c351fafa4d2768cb1f
DEPENDS_append_class-native = " python3-numpy-native"
