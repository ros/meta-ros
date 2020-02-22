# Copyright (c) 2020 LG Electronics, Inc.

inherit cmake_qt5

# Keep in mind that this needs widgets enabled in qtbase PACKAGECONFIG which webOS OSE explicitly disables:
# meta-webos/recipes-qt/qt5/qtbase_git.bbappend:PACKAGECONFIG_remove = "widgets"
