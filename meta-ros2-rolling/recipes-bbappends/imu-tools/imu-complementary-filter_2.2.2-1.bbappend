# Copyright (c) 2022 Wind River Systems, Inc.

# ERROR: imu-complementary-filter-2.1.1-2-r0 do_package_qa: QA Issue: non -staticdev package contains static .a library: imu-complementary-filter path '/usr/lib/imu_complementary_filter/libcomplementary_filter.a' [staticdev]
FILES:${PN}-staticdev += "${libdir}/${ROS_BPN}/libcomplementary_filter.a"
