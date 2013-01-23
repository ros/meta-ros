#!/bin/bash
## Installation script that should run in the virtual machine
# copy it into the virtual machine with:
# scp <user>@192.168.7.1:/<location of install.sh> .
# and run it:
# sh ./install-fuerte.sh
#
# local setting (must be adjusted)
USERNAME="lukas"
REPOS_PATH="home/lukas/ros-repos"
HOST_IP="192.168.7.1"
# This script does the following steps:
# create ssh login without password
#
ssh-keygen -t rsa
cat .ssh/id_rsa.pub | ssh $USERNAME@$HOST_IP 'cat >> .ssh/authorized_keys'
# create prepared rosinstall file
URL="ssh://$USERNAME@$HOST_IP/$REPOS_PATH"
cat > fuerte-ros-base.rosinstall << EOF
- git:
    local-name: catkin
    uri: $URL/catkin-release
    version: debian/ros-fuerte-catkin_0.4.4_lucid
- git:
    local-name: common_msgs
    uri: $URL/common_msgs-release
    version: debian/ros-fuerte-common-msgs_1.8.7_lucid
- git:
    local-name: gencpp
    uri: $URL/gencpp-release
    version: debian/ros-fuerte-gencpp_0.3.4_lucid
- git:
    local-name: genlisp
    uri: $URL/genlisp-release
    version: debian/ros-fuerte-genlisp_0.3.3_lucid
- git:
    local-name: genmsg
    uri: $URL/genmsg-release
    version: debian/ros-fuerte-genmsg_0.3.10_lucid
- git:
    local-name: genpy
    uri: $URL/genpy-release
    version: debian/ros-fuerte-genpy_0.3.7_lucid
- git:
    local-name: ros
    uri: $URL/ros-release
    version: debian/ros-fuerte-ros_1.8.9_lucid
- git:
    local-name: ros_comm
    uri: $URL/ros_comm-release
    version: debian/ros-fuerte-ros-comm_1.8.12_lucid
- git:
    local-name: roscpp_core
    uri: $URL/roscpp_core-release
    version: debian/ros-fuerte-roscpp-core_0.2.5_lucid
- git:
    local-name: rospack
    uri: $URL/rospack-release
    version: debian/ros-fuerte-rospack_2.0.13_lucid
- git:
    local-name: std_msgs
    uri: $URL/std_msgs-release
    version: debian/ros-fuerte-std-msgs_0.4.8_lucid
EOF
# run rosinstall
mkdir ~/ros
rosinstall --catkin ~/ros fuerte-ros-base.rosinstall
# apply patch
cd ~/ros/ros_comm
patch -p1 << EOF
diff -cr ros_comm/tools/rosbag/src/recorder.cpp ros_comm.patched/tools/rosbag/src/recorder.cpp
*** ros_comm/tools/rosbag/src/recorder.cpp	2012-12-06 14:12:06.773910947 +0100
--- ros_comm.patched/tools/rosbag/src/recorder.cpp	2012-12-06 14:14:49.145917680 +0100
***************
*** 436,442 ****
                  break;
              }
              boost::xtime xt;
!             boost::xtime_get(&xt, boost::TIME_UTC);
              xt.nsec += 250000000;
              queue_condition_.timed_wait(lock, xt);
              if (checkDuration(ros::Time::now()))
--- 436,442 ----
                  break;
              }
              boost::xtime xt;
!             boost::xtime_get(&xt, boost::TIME_UTC_);
              xt.nsec += 250000000;
              queue_condition_.timed_wait(lock, xt);
              if (checkDuration(ros::Time::now()))
EOF
# cmake invocation
cd ~/ros
mkdir build
cd build
cmake .. -DCMAKE_INSTALL_PREFIX=/opt/ros/fuerte -DSETUPTOOLS_DEB_LAYOUT=OFF
# compile and install
make
make install
# start roscore
. /opt/ros/fuerte/setup.sh
roscore
