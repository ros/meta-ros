# Copyright (c) 2020-2021 LG Electronics, Inc.

# Instead of fetching tvm and its submodules during do_compile, use separate tvm recipe
DEPENDS += "tvm"
RDEPENDS_${PN} += "tvm"

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-use-tvm-from-separate-recipe.patch"

# even with empty ${PN} we want to use this to pull runtime dependency on tvm
ALLOW_EMPTY_${PN} = "1"

# openblas PN is empty don't add runtime dependency on it
ROS_EXEC_DEPENDS_remove = "openblas"
