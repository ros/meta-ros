# Copyright (c) 2019-2020 LG Electronics, Inc.

DESCRIPTION = "Wrapper around yaml-cpp, it provides a fixed CMake module."

# We arrange for the platform yaml-cpp to be built from the same commit as that from which the ExternalProject is built. If the
# commit changes, the patch will not apply cleanly and we'll know we need to update the .bbappend for yaml-cpp.
DEPENDS += "yaml-cpp"

# ERROR: yaml-cpp-vendor-9.1.0-1-r0 do_package_qa: QA Issue: non -dev/-dbg/nativesdk- package yaml-cpp-vendor contains symlink .so '/opt/ros/rolling/lib/libyaml-cpp.so' [dev-so]
inherit ros_insane_dev_so
