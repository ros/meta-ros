# Copyright (c) 2022 Wind River Systems, Inc.

# ERROR: xacro-2.0.8-1-r0 do_package_qa: QA Issue: xacro: /work/core2-64-oe-linux/xacro/2.0.8-1-r0/packages-split/xacro/usr/bin/xacro maximum shebang size exceeded, the maximum size is 128.  xacro: /work/core2-64-oe-linux/xacro/2.0.8-1-r0/packages-split/xacro/usr/lib/xacro/xacro maximum shebang size exceeded, the maximum size is 128. [shebang-size]
do_install:append() {
    sed -i 's@^#!/.*python3@#!/usr/bin/env python3@g' ${D}${bindir}/xacro
    sed -i 's@^#!/.*python3@#!/usr/bin/env python3@g' ${D}${libdir}/xacro/xacro
}
