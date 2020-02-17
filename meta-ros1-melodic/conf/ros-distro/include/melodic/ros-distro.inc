# melodic/ros-distro.inc
# General configuration settings that are dependent on ROS_DISTRO.
#
# Copyright (c) 2019 LG Electronics, Inc.

ROS_DISTRO_CODENAME = "Melodic Morenia"

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
"

# roslisp depends on sbcl, for which there is no OE recipe
ROS_WORLD_SKIP_GROUPS += "lisp"
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

# recipes depending on something from meta-qt5 layer
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt5-layer', '', 'qt5', d)}"
# recipes depending on something from meta-qt4 layer
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt4-layer', '', 'qt4', d)}"
# recipes depending on something from meta-multimedia layer
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('BBFILE_COLLECTIONS', 'multimedia-layer', '', 'multimedia', d)}"

# recipes depending on 'opengl' in DISTRO_FEATURES
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', '', 'opengl', d)}"
# recipes depending on 'ffmpeg' which is restricted by 'commercial' LICENSE_FLAG
ROS_WORLD_SKIP_GROUPS += "${@ 'ffmpeg' if not d.getVar('LICENSE_FLAGS_WHITELIST') or 'commercial' not in d.getVar('LICENSE_FLAGS_WHITELIST').split() else ''}"
# recipes depending on 'gstreamer1.0-plugins-ugly' which is restricted by 'commercial' LICENSE_FLAG
ROS_WORLD_SKIP_GROUPS += "${@ 'gst-ugly' if not d.getVar('LICENSE_FLAGS_WHITELIST') or 'commercial' not in d.getVar('LICENSE_FLAGS_WHITELIST').split() else ''}"

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

# python-backports-ssl@meta-python
ROS_UNRESOLVED_PLATFORM_PKG_python-backports.ssl-match-hostname = "python-backports-ssl"

# python-pillow@meta-ros v5.1.0
ROS_UNRESOLVED_PLATFORM_PKG_python-imaging = "python-pillow"

# python-tornado45@meta-ros v4.5.3
ROS_UNRESOLVED_PLATFORM_PKG_python-tornado = "python-tornado45"

# python-twisted-core@meta-python (v18.4.0 instead of  bionic's v17.9.0)
ROS_UNRESOLVED_PLATFORM_PKG_python-twisted-core = "python-twisted-core"

# Used by:
# generated-recipes/audio-common/audio-play_0.3.3.bb
# generated-recipes/audio-common/audio-capture_0.3.3.bb
# generated-recipes/audio-common/sound-play_0.3.3.bb
# generated-recipes/gscam/gscam_1.0.1.bb
ROS_UNRESOLVED_PLATFORM_PKG_gstreamer1.0 = "gstreamer1.0"
ROS_UNRESOLVED_PLATFORM_PKG_libgstreamer1.0-dev = "gstreamer1.0"

# Used by:
# generated-recipes/audio-common/audio-play_0.3.3.bb
# generated-recipes/audio-common/audio-capture_0.3.3.bb
# generated-recipes/audio-common/sound-play_0.3.3.bb
# generated-recipes/gscam/gscam_1.0.1.bb
ROS_UNRESOLVED_PLATFORM_PKG_gstreamer1.0-plugins-base = "gstreamer1.0-plugins-base"
ROS_UNRESOLVED_PLATFORM_PKG_libgstreamer-plugins-base1.0-dev = "gstreamer1.0-plugins-base"

# Used by:
# generated-recipes/audio-common/audio-play_0.3.3.bb
# generated-recipes/audio-common/audio-capture_0.3.3.bb
# generated-recipes/audio-common/sound-play_0.3.3.bb
ROS_UNRESOLVED_PLATFORM_PKG_gstreamer1.0-plugins-good = "gstreamer1.0-plugins-good"

# Used by:
# generated-recipes/audio-common/audio-play_0.3.3.bb
# generated-recipes/audio-common/audio-capture_0.3.3.bb
# generated-recipes/audio-common/sound-play_0.3.3.bb
ROS_UNRESOLVED_PLATFORM_PKG_gstreamer1.0-plugins-ugly = "gstreamer1.0-plugins-ugly"

# Used by:
# generated-recipes/jsk-3rdparty/assimp-devel_2.1.13-1.bb
# generated-recipes/jsk-3rdparty/downward_2.1.13-1.bb
# generated-recipes/jsk-3rdparty/ff_2.1.13-1.bb
# generated-recipes/jsk-3rdparty/libcmt_2.1.13-1.bb
# generated-recipes/jsk-3rdparty/slic_2.1.13-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_ca-certificates = "ca-certificates"

# Used by:
# generated-recipes/rc-genicam-api/rc-genicam-api_2.2.2-1.bb
# generated-recipes/phidgets-drivers/phidgets-api_0.7.9-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libusb-1.0 = "libusb1"

# Used by:
# generated-recipes/kobuki-core/kobuki-ftdi_0.7.8.bb
# generated-recipes/phidgets-drivers/libphidget21_0.7.9-1.bb
# generated-recipes/cob-extern/libphidgets_0.6.14-1.bb
# generated-recipes/joystick-drivers/ps3joy_1.13.0-1.bb
# generated-recipes/schunk-modular-robotics/schunk-sdh_0.6.14-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libusb-dev = "libusb1"

# Used by:
# generated-recipes/pr2-controllers/robot-mechanism-controllers_1.10.17-1.bb
# generated-recipes/jsk-3rdparty/nlopt_2.1.13-1.bb
# generated-recipes/pr2-controllers/ethercat-trigger-controllers_1.10.17-1.bb
# generated-recipes/stage/stage_4.3.0.bb
ROS_UNRESOLVED_PLATFORM_PKG_libtool = "libtool"

# Used by:
# generated-recipes/ros-canopen/socketcan-interface_0.8.2-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_linux-kernel-headers = "linux-libc-headers"

# Used by:
# generated-recipes/image-pipeline/image-view_1.13.0-1.bb
# generated-recipes/webrtc-ros/webrtc_59.0.3.bb
# generated-recipes/stage/stage_4.3.0.bb
ROS_UNRESOLVED_PLATFORM_PKG_gtk2 = "gtk+"

# Used by:
# generated-recipes/optpp-catkin/optpp-catkin_2.4.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_autoconf = "autoconf"

# Used by:
# generated-recipes/openrtm-aist/openrtm-aist_1.1.2-3.bb
ROS_UNRESOLVED_PLATFORM_PKG_automake-native = "automake-native"

# Used by:
# generated-recipes/jsk-3rdparty/ff_2.1.13-1.bb
# generated-recipes/jsk-3rdparty/ffha_2.1.13-1.bb
# generated-recipes/jsk-3rdparty/downward_2.1.13-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_bison = "bison"

# Used by:
# generated-recipes/jsk-roseus/roseus_1.7.4-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_coreutils = "coreutils"

# Used by:
# generated-recipes/schunk-modular-robotics/schunk-sdh_0.6.14-1.bb
# generated-recipes/cob-extern/libntcan_0.6.14-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_dpkg = "dpkg"

# Used by:
# generated-recipes/jsk-3rdparty/ff_2.1.13-1.bb,
# generated-recipes/jsk-3rdparty/ffha_2.1.13-1.bb
# generated-recipes/jsk-3rdparty/downward_2.1.13-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_flex = "flex"

# Used by:
# generated-recipes/jsk-3rdparty/ffha_2.1.13-1.bb
# generated-recipes/jsk-3rdparty/downward_2.1.13-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_gawk = "gawk"

# Used by:
# generated-recipes/openrtm-aist/openrtm-aist_1.1.2-3.bb
ROS_UNRESOLVED_PLATFORM_PKG_libtool-native = "libtool-native"

# Used by:
# generated-recipes/visp/visp_3.2.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libxml2 = "libxml2"

# Used by:
# generated-recipes/kinesis-manager/kinesis-manager_2.0.1-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_log4cplus = "log4cplus"

# Used by:
# generated-recipes/vapor-master/vapor-master_0.3.0.bb
ROS_UNRESOLVED_PLATFORM_PKG_nodejs-native = "nodejs-native"

# Used by:
# generated-recipes/marti-common/swri-transform-util_2.11.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_proj = "proj"

# Used by:
# generated-recipes/cpr-multimaster-tools/message-relay_0.0.2-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python-cheetah = "python-cheetah"

# Used by:
# generated-recipes/calibration/calibration-estimation_0.10.14.bb
ROS_UNRESOLVED_PLATFORM_PKG_python-matplotlib = "python-matplotlib"

# Used by:
# generated-recipes/catkin-pip/catkin-pip_0.2.3-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python-pip = "python-pip"

# Used by:
# generated-recipes/mongodb-store/mongodb-store_0.5.2-1.bb
# generated-recipes/mongodb-store/mongodb-log_0.5.2-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python-pymongo = "python-pymongo"

# Used by:
# generated-recipes/geographic-info/geodesy_0.5.3.bb
ROS_UNRESOLVED_PLATFORM_PKG_python-pyproj = "python-pyproj"

# Used by:
# generated-recipes/ros-pytest/ros-pytest_0.1.2-2.bb
ROS_UNRESOLVED_PLATFORM_PKG_python-pytest = "python-pytest"

# Used by:
# generated-recipes/jsk-3rdparty/rostwitter_2.1.13-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python-requests = "python-requests"

# Used by:
# generated-recipes/jsk-3rdparty/rostwitter_2.1.13-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python-simplejson = "python-simplejson"

# Used by:
# generated-recipes/abseil-cpp/abseil-cpp_0.4.2-1.bb
# generated-recipes/jsk-3rdparty/julius_2.1.13-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_rsync = "rsync"

# Used by:
# generated-recipes/jsk-3rdparty/libsiftfast_2.1.13-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_subversion = "subversion"

# Used by:
# generated-recipes/trac-ik/trac-ik-python_1.5.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_swig = "swig"

# Used by:
# generated-recipes/spatio-temporal-voxel-layer/spatio-temporal-voxel-layer_1.3.5-2.bb
# generated-recipes/navigation-2d/nav2d-karto_0.4.2.bb
ROS_UNRESOLVED_PLATFORM_PKG_tbb = "tbb"

# Used by:
# generated-recipes/jsk-3rdparty/downward_2.1.13-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_time = "time"

# Used by:
# generated-recipes/convex-decomposition/convex-decomposition_0.1.12.bb
# generated-recipes/jsk-3rdparty/julius_2.1.13-1.bb
# generated-recipes/jsk-3rdparty/assimp-devel_2.1.13-1.bb
# generated-recipes/jsk-3rdparty/ff_2.1.13-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_unzip = "unzip"

# Used by:
# generated-recipes/openni2-camera/openni2-launch_0.4.2.bb
ROS_UNRESOLVED_PLATFORM_PKG_usbutils = "usbutils"

# Used by:
# generated-recipes/jsk-3rdparty/julius_2.1.13-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_wget = "wget"

# Used by:
# generated-recipes/webrtc-ros/webrtc_59.0.3.bb
ROS_UNRESOLVED_PLATFORM_PKG_wget-native = "wget-native"

# Used by:
# generated-recipes/vision-visp/visp-auto-tracker_0.11.1-1.bb
# generated-recipes/visp/visp_3.2.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_zbar = "zbar"

# Used by:
# generated-recipes/openrtm-aist-python/openrtm-aist-python_1.1.0.bb
# generated-recipes/eigenpy/eigenpy_1.6.9-1.bb
# generated-recipes/openrtm-aist/openrtm-aist_1.1.2-3.bb
# generated-recipes/pinocchio/pinocchio_2.2.1-1.bb
# generated-recipes/visp/visp_3.2.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_doxygen = "doxygen"

# Used by:
# generated-recipes/qt-metapackages/libqt-concurrent_1.0.1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libqt5-concurrent = "qtbase"

# Used by:
# generated-recipes/qt-metapackages/libqt-network_1.0.1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libqt5-network = "qtbase"

# Used by:
# generated-recipes/qt-metapackages/libqt-opengl-rosdev_1.0.1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libqt5-opengl-dev = "qtbase"

# Used by:
# generated-recipes/qt-metapackages/libqt-svg-rosdev_1.0.1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libqt5-svg-dev = "qtsvg"

# Used by:
# generated-recipes/cob-driver/cob-mimic_0.7.1-1.bb
# generated-recipes/cob-driver/cob-sound_0.7.1-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libvlc-dev = "vlc"
ROS_UNRESOLVED_PLATFORM_PKG_vlc = "vlc"

# Used by:
# generated-recipes/mavros/mavros_0.33.3-1.bb
# generated-recipes/underwater-simulation/uwsim_1.4.2-1.bb
# Just a package built by geographiclib
ROS_UNRESOLVED_PLATFORM_PKG_geographiclib-tools = "geographiclib-tools"

# Used by:
# generated-recipes/webrtc-ros/webrtc_59.0.3.bb
ROS_UNRESOLVED_PLATFORM_PKG_libglib-dev = "glib-2.0"

# Used by:
# generated-recipes/kobuki-core/kobuki-ftdi_0.7.8.bb
ROS_UNRESOLVED_PLATFORM_PKG_ftdi-eeprom = "libftdi"

# Used by:
# generated-recipes/rc-dynamics-api/rc-dynamics-api_0.10.0-1.bb
# generated-recipes/rc-visard/rc-visard-driver_2.7.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_protobuf = "protobuf"

# Used by:
# generated-recipes/yp-spur/ypspur_1.17.1-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_libreadline-dev = "readline"
ROS_UNRESOLVED_PLATFORM_PKG_libreadline = "readline"

# Used by:
# generated-recipes/robot-upstart/robot-upstart_0.3.0.bb
ROS_UNRESOLVED_PLATFORM_PKG_daemontools = "daemontools"

# Used by:
# generated-recipes/moveit/moveit-kinematics_1.0.2-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_liburdfdom-tools = "urdfdom"

# Used by:
# generated-recipes/python-qt-binding/python-qt-binding_0.3.6-2.bb
# generated-recipes/qt-gui-core/qt-gui_0.3.16-1.bb
# generated-recipes/visualstates/visualstates_0.2.3-2.bb
ROS_UNRESOLVED_PLATFORM_PKG_python-qt5-bindings = "python-pyqt5"
ROS_UNRESOLVED_PLATFORM_PKG_python3-qt5-bindings = "python3-pyqt5"

# Used by:
# generated-recipes/webkit-dependency/webkit-dependency_1.1.0.bb
ROS_UNRESOLVED_PLATFORM_PKG_python-qt5-bindings-webkit = "python-pyqt5"
ROS_UNRESOLVED_PLATFORM_PKG_python3-qt5-bindings-webkit = "python3-pyqt5"

# Used by:
# generated-recipes/visualstates/visualstates_0.2.3-2.bb
ROS_UNRESOLVED_PLATFORM_PKG_python-qt5-bindings-qsci = "python-pyqt5"
ROS_UNRESOLVED_PLATFORM_PKG_python3-qt5-bindings-qsci = "python3-pyqt5"

# Used by:
# generated-recipes/gl-dependency/gl-dependency_1.1.0.bb
ROS_UNRESOLVED_PLATFORM_PKG_python-qt5-bindings-gl = "python-pyqt5"
ROS_UNRESOLVED_PLATFORM_PKG_python3-qt5-bindings-gl = "python3-pyqt5"

# tango-icon-theme isn't available, but adwaita-icon-theme should be compatible
# Used by:
# generated-recipes/qt-gui-core/qt-gui_0.3.16-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_tango-icon-theme = "adwaita-icon-theme"

# Used by:
# generated-recipes/rviz-visual-tools/rviz-visual-tools_3.8.0-4.bb
ROS_UNRESOLVED_PLATFORM_PKG_libqt5x11extras5-dev = "qtx11extras"

#ROS_UNRESOLVED_PLATFORM_PKG_arduino-core = "arduino-core"
ROS_UNRESOLVED_PLATFORM_PKG_bluez = "bluez5"
ROS_UNRESOLVED_PLATFORM_PKG_clang-tidy = "clang-tidy"
#ROS_UNRESOLVED_PLATFORM_PKG_coinor-libipopt-dev = "coinor-libipopt-dev"
#ROS_UNRESOLVED_PLATFORM_PKG_cwiid-dev = "cwiid-dev"
#ROS_UNRESOLVED_PLATFORM_PKG_gforth = "gforth"
#ROS_UNRESOLVED_PLATFORM_PKG_gfortran = "gfortran"
ROS_UNRESOLVED_PLATFORM_PKG_libasound2-dev = "alsa-lib"
ROS_UNRESOLVED_PLATFORM_PKG_libcap-dev = "libcap"
#ROS_UNRESOLVED_PLATFORM_PKG_libcoin80-dev = "libcoin80-dev"
ROS_UNRESOLVED_PLATFORM_PKG_libdc1394-dev = "libdc1394"
#ROS_UNRESOLVED_PLATFORM_PKG_libdmtx-dev = "libdmtx-dev"
ROS_UNRESOLVED_PLATFORM_PKG_libftdi-dev = "libftdi"
# with cpp-wrapper PACKAGECONFIG enabled
ROS_UNRESOLVED_PLATFORM_PKG_libftdipp-dev = "libftdi"
#ROS_UNRESOLVED_PLATFORM_PKG_libgeos++-dev = "libgeos++-dev"
ROS_UNRESOLVED_PLATFORM_PKG_libgphoto-dev = "libgphoto2"
ROS_UNRESOLVED_PLATFORM_PKG_libgps = "gpsd"
#ROS_UNRESOLVED_PLATFORM_PKG_libgts = "libgts"
ROS_UNRESOLVED_PLATFORM_PKG_libmodbus-dev = "libmodbus"
ROS_UNRESOLVED_PLATFORM_PKG_libmongoclient-dev = "mongodb"
ROS_UNRESOLVED_PLATFORM_PKG_libncurses-dev = "ncurses"
#ROS_UNRESOLVED_PLATFORM_PKG_libnlopt-dev = "libnlopt-dev"
#ROS_UNRESOLVED_PLATFORM_PKG_libnlopt0 = "libnlopt0"
#ROS_UNRESOLVED_PLATFORM_PKG_libogre-dev = "libogre-dev"
#ROS_UNRESOLVED_PLATFORM_PKG_libois-dev = "libois-dev"
#ROS_UNRESOLVED_PLATFORM_PKG_libopenexr-dev = "libopenexr-dev"
#ROS_UNRESOLVED_PLATFORM_PKG_libopenni-dev = "libopenni-dev"
#ROS_UNRESOLVED_PLATFORM_PKG_libopenni2-dev = "libopenni2-dev"
#ROS_UNRESOLVED_PLATFORM_PKG_libopenscenegraph = "libopenscenegraph"
#ROS_UNRESOLVED_PLATFORM_PKG_libopenvdb = "libopenvdb"
#ROS_UNRESOLVED_PLATFORM_PKG_libopenvdb-dev = "libopenvdb-dev"
ROS_UNRESOLVED_PLATFORM_PKG_libpng-dev = "libpng"
#ROS_UNRESOLVED_PLATFORM_PKG_libpng12-dev = "libpng12-dev"
ROS_UNRESOLVED_PLATFORM_PKG_libpulse-dev = "pulseaudio"
ROS_UNRESOLVED_PLATFORM_PKG_libsensors4-dev = "lmsensors"
#ROS_UNRESOLVED_PLATFORM_PKG_libspnav-dev = "libspnav-dev"
ROS_UNRESOLVED_PLATFORM_PKG_libv4l-dev = "v4l-utils"
#ROS_UNRESOLVED_PLATFORM_PKG_libvtk-qt = "libvtk-qt"
ROS_UNRESOLVED_PLATFORM_PKG_mongodb = "mongodb"
#ROS_UNRESOLVED_PLATFORM_PKG_muparser = "muparser"
#ROS_UNRESOLVED_PLATFORM_PKG_npm-native = "npm-native"
#ROS_UNRESOLVED_PLATFORM_PKG_omniorb = "omniorb"
#ROS_UNRESOLVED_PLATFORM_PKG_python-avahi = "python-avahi"
ROS_UNRESOLVED_PLATFORM_PKG_python-bluez = "python-pybluez"
#ROS_UNRESOLVED_PLATFORM_PKG_python-cairosvg = "python-cairosvg"
#ROS_UNRESOLVED_PLATFORM_PKG_python-catkin-tools = "python-catkin-tools"
#ROS_UNRESOLVED_PLATFORM_PKG_python-cwiid = "python-cwiid"
#ROS_UNRESOLVED_PLATFORM_PKG_python-docker = "python-docker"
#ROS_UNRESOLVED_PLATFORM_PKG_python-joblib = "python-joblib"
#ROS_UNRESOLVED_PLATFORM_PKG_python-libpgm-pip = "python-libpgm-pip"
#ROS_UNRESOLVED_PLATFORM_PKG_python-mechanize = "python-mechanize"
#ROS_UNRESOLVED_PLATFORM_PKG_python-omniorb = "python-omniorb"
#ROS_UNRESOLVED_PLATFORM_PKG_python-pyassimp = "python-pyassimp"
ROS_UNRESOLVED_PLATFORM_PKG_python-pyaudio = "python-pyalsaaudio"
#ROS_UNRESOLVED_PLATFORM_PKG_python-pyusb-pip = "python-pyusb-pip"
#ROS_UNRESOLVED_PLATFORM_PKG_python-requests-oauthlib = "python-requests-oauthlib"
#ROS_UNRESOLVED_PLATFORM_PKG_python-scipy = "python-scipy"
#ROS_UNRESOLVED_PLATFORM_PKG_python-speechrecognition-pip = "python-speechrecognition-pip"
ROS_UNRESOLVED_PLATFORM_PKG_python-websocket = "python3-websockets"
