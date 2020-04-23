# Copyright (c) 2020 LG Electronics, Inc.

# ERROR: ypspur-1.17.1-1-r0 do_package_qa: QA Issue:
# non -dev/-dbg/nativesdk- package contains symlink .so: ypspur path '/work/aarch64-oe-linux/ypspur/1.17.1-1-r0/packages-split/ypspur/usr/lib/libypspur-md.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: ypspur path '/work/aarch64-oe-linux/ypspur/1.17.1-1-r0/packages-split/ypspur/usr/lib/libformula-calc.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: ypspur path '/work/aarch64-oe-linux/ypspur/1.17.1-1-r0/packages-split/ypspur/usr/lib/libypspur.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: ypspur path '/work/aarch64-oe-linux/ypspur/1.17.1-1-r0/packages-split/ypspur/usr/lib/libcarte2d.so' [dev-so]
inherit ros_insane_dev_so
