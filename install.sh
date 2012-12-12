# create ssh login without password
ssh-keygen -t rsa
cat .ssh/id_rsa.pub | ssh lukas@192.168.7.1 'cat >> .ssh/authorized_keys'
# copy prepared rosinstall file
scp lukas@192.168.7.1:/home/lukas/ros_server/fuerte-ros-base.rosinstall .
# run rosinstall
mkdir ~/ros
rosinstall --catkin ~/ros fuerte-ros-base.rosinstall
# install rospkg manually
## git clone ssh://lukas@192.168.7.1//home/lukas/ros_server/rospkg
## cd ~/rospkg
## python setup.py install
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
# add own name to hosts
echo -e '127.0.0.1\tqemux86-64.localdomain\t\tqemux86-64' >> /etc/hosts
# start roscore
. /opt/ros/fuerte/setup.sh
roscore
