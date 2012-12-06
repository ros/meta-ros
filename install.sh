# create ssh login without password
ssh-keygen -t rsa
cat .ssh/id_rsa.pub | ssh lukas@192.168.7.1 'cat >> .ssh/authorized_keys'
# copy prepared rosinstall file
scp lukas@192.168.7.1:/home/lukas/ros_server/fuerte-ros-base.rosinstall .
# run rosinstall
mkdir ~/ros
rosinstall --catkin ~/ros fuerte-ros-base.rosinstall
# install rospkg manually
git clone ssh://lukas@192.168.7.1//home/lukas/ros_server/rospkg
cd ~/rospkg
python setup.py install
# cmake invocation
cd ~/ros
mkdir build
cd build
cmake .. -DCMAKE_INSTALL_PREFIX=/opt/ros/fuerte -DSETUPTOOLS_DEB_LAYOUT=OFF