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
tar -xzf ../src.tar.gz
# patch catkin
patch -p1 << EOF
*** A/src/catkin/cmake/python.cmake	2013-01-04 14:22:33.223884756 +0100
--- B/src/catkin/cmake/python.cmake	2013-01-04 14:28:01.971898385 +0100
***************
*** 6,12 ****
  set(PYTHON_VERSION_XDOTY ${PYTHON_VERSION_XDOTY} CACHE STRING "Python version")
  
  #This should be resolved automatically one day...
! option(SETUPTOOLS_DEB_LAYOUT "ON for debian style python packages layout" ON)
  
  if(APPLE OR MSVC)
    set(SETUPTOOLS_DEB_LAYOUT OFF)
--- 6,12 ----
  set(PYTHON_VERSION_XDOTY ${PYTHON_VERSION_XDOTY} CACHE STRING "Python version")
  
  #This should be resolved automatically one day...
! option(SETUPTOOLS_DEB_LAYOUT "ON for debian style python packages layout" OFF)
  
  if(APPLE OR MSVC)
    set(SETUPTOOLS_DEB_LAYOUT OFF)
EOF
# run catkin
./src/catkin/bin/catkin_make_isolated --install
