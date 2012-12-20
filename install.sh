## Installation script that should run in the virtual machine
# copy it into the virtual machine with:
# scp <user>@192.168.7.1:/<location of install.sh> .
# and run it:
# sh ./install.sh
#
# This script does the following steps:
# create ssh login without password
USERNAME = lukas
REPOS_PATH = /home/lukas/ros_server/
HOST_IP = 192.168.7.1
ssh-keygen -t rsa
cat .ssh/id_rsa.pub | ssh $USERNAME@$HOST_IP 'cat >> .ssh/authorized_keys'
# copy prepared rosinstall file
scp $USERNAME@$HOST_IP:$REPOS_PATH/fuerte-ros-base.rosinstall .
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
