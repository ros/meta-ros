#!/bin/bash
## Installation script that should run in the virtual machine
# copy it into the virtual machine with:
# scp <user>@192.168.7.1:/<location of install.sh> .
# and run it:
# sh ./install-groovy.sh
#
# local setting (must be adjusted)
USERNAME="lukas"
HOST_IP="192.168.7.1"
SRC_DIRECTORY="/home/lukas/ros_catkin_ws"
# This script does the following steps:
# copy source archive
scp $USERNAME@$HOST_IP:$SRC_DIRECTORY/src.tar.gz .
mkdir ros_catkin_ws
cd ros_catkin_ws
# extract
tar -xzf ../src.tar.gz
# compile, make and install
catkin_make_isolated --install
