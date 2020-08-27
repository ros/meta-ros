# Copyright (c) 2020 LG Electronics, Inc.

# Fix shebang, because /bin/env most likely doesn't exist anywhere
# ERROR: mini-maxwell-2.1.13-1-r0 do_package_qa: QA Issue: /opt/ros/melodic/share/mini_maxwell/scripts/setfilters26.py contained in package mini-maxwell requires /bin/env, but no providers found in RDEPENDS_mini-maxwell? [file-rdeps]
# ERROR: mini-maxwell-2.1.13-1-r0 do_package_qa: QA Issue: /opt/ros/melodic/share/mini_maxwell/scripts/setfilters.py contained in package mini-maxwell requires /bin/env, but no providers found in RDEPENDS_mini-maxwell? [file-rdeps]
# ...
# There are few scripts with correct shebang, list only those with /bin/env:
# /jenkins/mjansa/build/ros/ros1-melodic-dunfell/tmp-glibc/work/aarch64-oe-linux/mini-maxwell/2.1.13-1-r0/image/opt/ros/melodic/share/mini_maxwell/scripts/drc_2015_environment.py:#!/usr/bin/env python
# /jenkins/mjansa/build/ros/ros1-melodic-dunfell/tmp-glibc/work/aarch64-oe-linux/mini-maxwell/2.1.13-1-r0/image/opt/ros/melodic/share/mini_maxwell/scripts/mm2client.py:#!/bin/env python
# /jenkins/mjansa/build/ros/ros1-melodic-dunfell/tmp-glibc/work/aarch64-oe-linux/mini-maxwell/2.1.13-1-r0/image/opt/ros/melodic/share/mini_maxwell/scripts/periodic.py:#!/bin/env python
# /jenkins/mjansa/build/ros/ros1-melodic-dunfell/tmp-glibc/work/aarch64-oe-linux/mini-maxwell/2.1.13-1-r0/image/opt/ros/melodic/share/mini_maxwell/scripts/periodic26.py:#!/bin/env python
# /jenkins/mjansa/build/ros/ros1-melodic-dunfell/tmp-glibc/work/aarch64-oe-linux/mini-maxwell/2.1.13-1-r0/image/opt/ros/melodic/share/mini_maxwell/scripts/ros_client.py:#!/usr/bin/env python
# /jenkins/mjansa/build/ros/ros1-melodic-dunfell/tmp-glibc/work/aarch64-oe-linux/mini-maxwell/2.1.13-1-r0/image/opt/ros/melodic/share/mini_maxwell/scripts/setfilters.py:#!/bin/env python
# /jenkins/mjansa/build/ros/ros1-melodic-dunfell/tmp-glibc/work/aarch64-oe-linux/mini-maxwell/2.1.13-1-r0/image/opt/ros/melodic/share/mini_maxwell/scripts/setfilters26.py:#!/bin/env python

# /jenkins/mjansa/build/ros/ros1-melodic-dunfell/tmp-glibc/work/aarch64-oe-linux/mini-maxwell/2.1.13-1-r0/image/opt/ros/melodic/share/mini_maxwell/scripts/sample/100k_1m_connection.py:#!/usr/bin/env python
# /jenkins/mjansa/build/ros/ros1-melodic-dunfell/tmp-glibc/work/aarch64-oe-linux/mini-maxwell/2.1.13-1-r0/image/opt/ros/melodic/share/mini_maxwell/scripts/sample/random_connection.py:#!/usr/bin/env python

# /jenkins/mjansa/build/ros/ros1-melodic-dunfell/tmp-glibc/work/aarch64-oe-linux/mini-maxwell/2.1.13-1-r0/image/opt/ros/melodic/share/mini_maxwell/scripts/simple_server/simple_echo_client.py:#!/usr/bin/env python
# /jenkins/mjansa/build/ros/ros1-melodic-dunfell/tmp-glibc/work/aarch64-oe-linux/mini-maxwell/2.1.13-1-r0/image/opt/ros/melodic/share/mini_maxwell/scripts/simple_server/simple_echo_server.py:#!/usr/bin/env python
# /jenkins/mjansa/build/ros/ros1-melodic-dunfell/tmp-glibc/work/aarch64-oe-linux/mini-maxwell/2.1.13-1-r0/image/opt/ros/melodic/share/mini_maxwell/scripts/simple_server/simple_send_packet.py:#!/usr/bin/env python

do_install_append() {
    sed -i 's@^#!/bin/env@#!/usr/bin/env@g' ${D}${ros_datadir}/mini_maxwell/scripts/setfilters26.py \
        ${D}${ros_datadir}/mini_maxwell/scripts/setfilters.py \
        ${D}${ros_datadir}/mini_maxwell/scripts/mm2client.py \
        ${D}${ros_datadir}/mini_maxwell/scripts/periodic.py \
        ${D}${ros_datadir}/mini_maxwell/scripts/periodic26.py
}
