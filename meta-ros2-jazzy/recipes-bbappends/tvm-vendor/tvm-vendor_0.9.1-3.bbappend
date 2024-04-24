# Copyright (c) 2020-2021 LG Electronics, Inc.
# Copyright (c) 2024 Wind River Systems, Inc.

# Instead of fetching tvm and its submodules during do_compile, use separate tvm recipe
DEPENDS += "tvm"
RDEPENDS:${PN} += "tvm"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-use-tvm-from-separate-recipe.patch"

# even with empty ${PN} we want to use this to pull runtime dependency on tvm
ALLOW_EMPTY:${PN} = "1"

# openblas PN is empty don't add runtime dependency on it
ROS_EXEC_DEPENDS:remove = "openblas"

# spirv-headers PN is empty don't add runtime dependency on it
ROS_EXEC_DEPENDS:remove = "spirv-headers"

# Replace the virtual provider with the package name
ROS_EXEC_DEPENDS:remove = "virtual/opencl-icd"
ROS_EXEC_DEPENDS:append = "virtual-opencl-icd"
