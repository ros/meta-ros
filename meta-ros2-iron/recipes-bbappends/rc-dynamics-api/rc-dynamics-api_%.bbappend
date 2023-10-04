# Copyright (c) 2021 LG Electronics, Inc.

# it tries to run js_embed and fails with:
# /bin/sh: js_embed: command not found
# because it does depend only on target protobuf, not protobuf-native:
DEPENDS += "protobuf-native"

# ERROR: rc-dynamics-api-0.10.3-1-r0 do_package_qa: QA Issue:
# non -dev/-dbg/nativesdk- package contains symlink .so: rc-dynamics-api path '/work/core2-64-oe-linux/rc-dynamics-api/0.10.3-1-r0/packages-split/rc-dynamics-api/usr/lib/librc_dynamics_api.so' [dev-so]
inherit ros_insane_dev_so
