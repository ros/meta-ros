# melodic/ros-distro.inc
# General configuration settings that are dependent on ROS_DISTRO.
#
# Copyright (c) 2019-2020 LG Electronics, Inc.

ROS_DISTRO_CODENAME = "Melodic Morenia"

ROS1_DISTRO = "melodic"

# The platform release that the metadata for this ROS distro targets. This determines the versions of the platform packages that
# OE must provide. It must be one of the values of ROS_DISTRO_RELEASE_PLATFORMS (which is set in
# generated/superflore-ros-distro.inc).
ROS_DISTRO_BASELINE_PLATFORM = "ubuntu-bionic"

require conf/ros-distro/include/melodic/generated/superflore-datetime.inc
require conf/ros-distro/include/melodic/generated/superflore-ros-distro.inc
require conf/ros-distro/include/melodic/ros-distro-recipe-blacklist.inc
require conf/ros-distro/include/melodic/ros-distro-preferred-versions.inc
require conf/ros-distro/include/melodic/ros-distro-preferred-providers.inc

# Override settings from generated/superflore-ros-distro.inc here.

# Since superflore doesn't know when it's generating a recipe that it will be for a build tool, it can't know that what's in
# ROS_EXEC_DEPEND are also build tools. Manually add them here.
ROS_SUPERFLORE_GENERATED_BUILDTOOLS += " \
    cmake-modules-native \
    rospack-native \
"

# roslisp depends on sbcl, for which there is no OE recipe
ROS_WORLD_SKIP_GROUPS += "lisp"
# There is recipe for glfw in meta-oe in dunfell:
# http://cgit.openembedded.org/meta-openembedded/commit/meta-oe/recipes-core/glfw/glfw_3.3.bb?id=a7464eaa69a7ee4734001aab2e232102e7135772
# but we don't have a backports layer from dunfell yet, lets skip it for now
ROS_WORLD_SKIP_GROUPS += "glfw"
# recipes depending on gazebo, for which there is no OE recipe
ROS_WORLD_SKIP_GROUPS += "gazebo"
# recipes depending on wxpython
ROS_WORLD_SKIP_GROUPS += "wxpython"
# recipes depending on libnlopt0 (http://neuro.debian.net/pkgs/libnlopt0.html)
ROS_WORLD_SKIP_GROUPS += "trac-ik"
# recipes depending on libogre
# there was ogre recipe in OE-classic 10 years ago:
# https://github.com/openembedded/openembedded/blob/master/recipes/ogre/ogre-egl_svn.bb
# but wasn'te ever ported to new layers
ROS_WORLD_SKIP_GROUPS += "ogre"
# recipes depending on python-scipy
ROS_WORLD_SKIP_GROUPS += "python-scipy"
# recipes depending on python-speechrecognition-pip
ROS_WORLD_SKIP_GROUPS += "python-speechrecognition-pip"
# recipes depending on python-gi
ROS_WORLD_SKIP_GROUPS += "python-gi"
# recipes depending on python-imageio
ROS_WORLD_SKIP_GROUPS += "python-imageio"
# recipes depending on nkf - Network Kanji code conversion Filter - https://packages.debian.org/sid/text/nkf
ROS_WORLD_SKIP_GROUPS += "nkf"
# recipes depending on rospilot which depends on ROS_UNRESOLVED_DEP-python-tilestache, ROS_UNRESOLVED_DEP-python-mapnik, ROS_UNRESOLVED_DEP-libnl-3, ROS_UNRESOLVED_DEP-postgresql-postgis, ROS_UNRESOLVED_DEP-python-cherrypy, ROS_UNRESOLVED_DEP-osm2pgsql, ROS_UNRESOLVED_DEP-dnsmasq, ROS_UNRESOLVED_DEP-mapnik-utils, ROS_UNRESOLVED_DEP-hostapd, ROS_UNRESOLVED_DEP-python-colorama, ROS_UNRESOLVED_DEP-gdal-bin, ROS_UNRESOLVED_DEP-libmicrohttpd, ROS_UNRESOLVED_DEP-libnl-3-dev
ROS_WORLD_SKIP_GROUPS += "rospilot"
# recipes depending on parrot-arsdk which depends on ROS_UNRESOLVED_DEP-automake, ROS_UNRESOLVED_DEP-yasm, ROS_UNRESOLVED_DEP-libavahi-core-dev, ROS_UNRESOLVED_DEP-nasm, ROS_UNRESOLVED_DEP-libavahi-client-dev
ROS_WORLD_SKIP_GROUPS += "parrot-arsdk"
# recipes depending on clang-tidy
ROS_WORLD_SKIP_GROUPS += "clang-tidy"
# recipes depending on muparser
ROS_WORLD_SKIP_GROUPS += "muparser"
# recipes depending on openni (libopenni-dev)
ROS_WORLD_SKIP_GROUPS += "openni"
# recipes depending on openni2 (libopenni2-dev)
ROS_WORLD_SKIP_GROUPS += "openni2"
# recipes depending on coinor-libipopt
ROS_WORLD_SKIP_GROUPS += "coinor-libipopt"
# recipes depending on libvtk-qt
ROS_WORLD_SKIP_GROUPS += "vtk-qt"
# recipes depending on libopenscenegraph
ROS_WORLD_SKIP_GROUPS += "osg"
# recipes depending on legacy mongo-cxx-driver (https://packages.debian.org/source/stretch/mongo-cxx-driver-legacy)
# the mongodb recipe in meta-oe installs just the binaries mongoc, mongos, install_compass
# the header files searched by mongo-store, warehouse-ros-mongo cmake files cmake/FindMongoClient.cmake and cmake/FindMongoDB.cmake
# aren't even part of current version of mongo-cxx-driver
# src/mongo/client/dbclient.h and src/mongo/client/dbclientinterface.h are only in the legacy branches
ROS_WORLD_SKIP_GROUPS += "mongodb-legacy-cxx-driver"
# provides the same libfcl.so.0.6 as platform fcl recipe, causing conflicts
# you need to make sure only one of these is included in dependency tree and in our world builds
# it was always including both, lets blacklist fcl-catkin, because nothing directly depends on it
ROS_WORLD_SKIP_GROUPS += "fcl-catkin"
# recipes depending on python-dialogflow-pip
ROS_WORLD_SKIP_GROUPS += "python-dialogflow-pip"
# recipes depending on pydrive-pip
ROS_WORLD_SKIP_GROUPS += "pydrive-pip"
# recipes depending on pugixml
ROS_WORLD_SKIP_GROUPS += "pugixml"
# recipes depending on python-omniorb
ROS_WORLD_SKIP_GROUPS += "python-omniorb"
# recipes depending on python-mechanize
ROS_WORLD_SKIP_GROUPS += "python-mechanize"
# recipes depending on lcm from meta-uav https://layers.openembedded.org/layerindex/recipe/25701/
ROS_WORLD_SKIP_GROUPS += "lcm"
# recipes depending on libpqxx (https://packages.debian.org/source/sid/libpqxx)
ROS_WORLD_SKIP_GROUPS += "libpqxx"
# recipes depending on ROS_UNRESOLVED_DEP-python-cwiid
ROS_WORLD_SKIP_GROUPS += "python-cwiid"
# recipes depending on ROS_UNRESOLVED_DEP-libspnav-dev
ROS_WORLD_SKIP_GROUPS += "libspnav"
# heifu-* recipes depending on ros-utils which seems to be this component:
# https://gitlab.pdmfc.com/drones/ros1/drone-generic/tree/master/src/ros_utils
# which isn't public as reported here:
# https://github.com/ros/rosdistro/pull/26336#issuecomment-696373544
ROS_WORLD_SKIP_GROUPS += "heifu-ros-utils"
# expects users to install official IDS uEye drivers (http://en.ids-imaging.com/download-ueye.html)
ROS_WORLD_SKIP_GROUPS += "ueye"

# do_configure failures
ROS_WORLD_SKIP_GROUPS += " \
    dccomms-ros \
    dynamic-graph-python \
    hdf5-map-io \
    jderobot-carviz \
    lanelet2-traffic-rules \
    novatel-oem7-driver \
    pyros-utils \
"

# do_compile failures
ROS_WORLD_SKIP_GROUPS += " \
    assimp-devel \
    bayesian-belief-networks \
    canopen-master \
    cob-generic-can \
    cob-obstacle-distance-moveit \
    downward \
    exotica-collision-scene-fcl \
    fetch-drivers \
    ff \
    ffha \
    fmi-adapter \
    hector-pose-estimation-core \
    hpp-fcl \
    julius \
    libg2o \
    libphidget21 \
    libphidgets \
    libsiftfast \
    libuvc-camera \
    map-merge-3d \
    mobile-robot-simulator \
    multisense-ros \
    naoqi-libqi \
    nerian-stereo \
    nlopt \
    obj-to-pointcloud \
    odva-ethernetip \
    p2os-urdf \
    pointgrey-camera-driver \
    pr2-description \
    qt-gui-cpp \
    rail-mesh-icp \
    rc-dynamics-api \
    robot-body-filter \
    ros-reflexxes \
    rosbag-editor \
    rosflight \
    rosmon-core \
    sainsmart-relay-usb \
    sbpl-lattice-planner \
    schunk-libm5api \
    schunk-sdh \
    soem \
    stage-ros \
    usb-cam-controllers \
    wamv-description \
"

# do_compile failures
ROS_WORLD_SKIP_GROUPS += " \
    omnibase-description \
    omnibase-gazebo \
"

# recipes depending on various unavailable python modules
# ERROR: Nothing PROVIDES 'ROS_UNRESOLVED_DEP-python-cairosvg' (but generated-recipes/fiducials/aruco-detect_0.11.0-1.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing PROVIDES 'ROS_UNRESOLVED_DEP-python-joblib' (but generated-recipes/fiducials/aruco-detect_0.11.0-1.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing PROVIDES 'ROS_UNRESOLVED_DEP-python-urlgrabber' (but generated-recipes/jsk-visualization/jsk-rqt-plugins_2.1.5.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing PROVIDES 'ROS_UNRESOLVED_DEP-python-sklearn' (but generated-recipes/jsk-visualization/jsk-rqt-plugins_2.1.5.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing PROVIDES 'ROS_UNRESOLVED_DEP-python-cairo' (but generated-recipes/rqt-bag/rqt-bag-plugins_0.4.12.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing PROVIDES 'ROS_UNRESOLVED_DEP-python-opengl' (but generated-recipes/rqt-pose-view/rqt-pose-view_0.5.8.bb DEPENDS on or otherwise requires it)
# ERROR: Nothing RPROVIDES 'ROS_UNRESOLVED_DEP-python-termcolor' (but generated-recipes/criutils/criutils_0.1.3-2.bb RDEPENDS on or otherwise requires it)
ROS_WORLD_SKIP_GROUPS += "python-deps"

# recipes depending on something from meta-qt5 layer
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt5-layer', '', 'qt5', d)}"
# recipes depending on something from meta-qt4 layer
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt4-layer', '', 'qt4', d)}"
# recipes depending on something from meta-multimedia layer
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('BBFILE_COLLECTIONS', 'multimedia-layer', '', 'multimedia', d)}"

# recipes depending on 'x11' in DISTRO_FEATURES
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('DISTRO_FEATURES', 'x11', '', 'x11', d)}"
# recipes depending on 'opengl' in DISTRO_FEATURES
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', '', 'opengl', d)}"
# recipes depending on 'ffmpeg' which is restricted by 'commercial' LICENSE_FLAG
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains_any('LICENSE_FLAGS_WHITELIST', ['commercial', 'ffmpeg', 'commercial_ffmpeg'], '', 'ffmpeg', d)}"
# recipes depending on 'x264' (ffmpeg does depend on it by default as well) which is restricted by 'commercial' LICENSE_FLAG
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains_any('LICENSE_FLAGS_WHITELIST', ['commercial', 'x264', 'commercial_x264'], '', 'x264', d)}"
# recipes depending on 'gstreamer1.0-plugins-ugly' which is restricted by 'commercial' LICENSE_FLAG
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains_any('LICENSE_FLAGS_WHITELIST', ['commercial', 'gstreamer1.0-plugins-ugly', 'commercial_gstreamer1.0-plugins-ugly'], '', 'gst-ugly', d)}"
# recipes depending on vlc from meta-multimedia layer which depends on ffmpeg which has commercial LICENSE_FLAGS restriction
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains_any('LICENSE_FLAGS_WHITELIST', ['commercial', 'vlc', 'commercial_vlc'], '', 'vlc', d)}"

# recipes depending on python*-pyqt5 from meta-qt5 layer
# Use separate group, because e.g. webOS OSE has meta-qt5 layer included, but python*-pyqt5
# is blacklisted, because webOS OSE is missing newer meta-qt5 from warrior with older meta-oe thud which has
# incompatible old sip
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt5-layer', '', 'pyqt5', d)}"

# Must use a _pn- override in this file to override the ROS_BUILD_TYPE of a generated recipe,
# because we need to set this variable before the "inherit" line in the recipe is parsed,
# and having it in a .bbappend sets it too late.
ROS_BUILD_TYPE_pn-python-orocos-kdl = "catkin"

# Otherwise it will use cmake as specified in
# https://github.com/mavlink/mavlink-gbp-release/blob/release/melodic/mavlink/2019.11.11-1/package.xml#L29
# but that doesn't respect the prefix set in meta-ros-common/classes/ros_opt_prefix.bbclass
ROS_BUILD_TYPE_pn-mavlink = "catkin"
