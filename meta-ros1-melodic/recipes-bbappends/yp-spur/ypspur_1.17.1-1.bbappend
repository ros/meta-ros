# Copyright (c) 2020 LG Electronics, Inc.

# ERROR: ypspur-1.17.1-1-r0 do_package_qa: QA Issue:
# non -dev/-dbg/nativesdk- package contains symlink .so: ypspur path '/work/aarch64-oe-linux/ypspur/1.17.1-1-r0/packages-split/ypspur/usr/lib/libypspur-md.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: ypspur path '/work/aarch64-oe-linux/ypspur/1.17.1-1-r0/packages-split/ypspur/usr/lib/libformula-calc.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: ypspur path '/work/aarch64-oe-linux/ypspur/1.17.1-1-r0/packages-split/ypspur/usr/lib/libypspur.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: ypspur path '/work/aarch64-oe-linux/ypspur/1.17.1-1-r0/packages-split/ypspur/usr/lib/libcarte2d.so' [dev-so]
inherit ros_insane_dev_so

# stage bindir as well, because YPSpurTargets-noconfig.cmake checks for
# ypspur-coordinator, ypspur-free, ypspur-interpreter even when it's not
# called during the build (so we don't need to use ypspur-native to provide them)
#
# list(APPEND _IMPORT_CHECK_FILES_FOR_ypspur-coordinator "${_IMPORT_PREFIX}/bin/ypspur-coordinator" )
# list(APPEND _IMPORT_CHECK_FILES_FOR_ypspur-free "${_IMPORT_PREFIX}/bin/ypspur-free" )
# list(APPEND _IMPORT_CHECK_FILES_FOR_ypspur-interpreter "${_IMPORT_PREFIX}/bin/ypspur-interpreter" )
SYSROOT_DIRS_append = " \
    ${bindir} \
"
