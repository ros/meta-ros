# Copyright (c) 2020 LG Electronics, Inc.

# Fix typo on shebang and use /usr/bin/env
# ERROR: ubiquity-motor-0.10.0-1-r0 do_package_qa: QA Issue: /usr/opt/ros/melodic/lib/ubiquity_motor/test_motor_board.py contained in package ubiquity-motor requires /usr/bin/pythmn, but no providers found in RDEPENDS_ubiquity-motor? [file-rdeps]

do_install_append() {
    sed -i 's@^#!/usr/bin/pythmn@#!/usr/bin/env python@g' ${D}${ros_libdir}/ubiquity_motor/test_motor_board.py
}
