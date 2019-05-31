# Copyright (c) 2008-2019 LG Electronics, Inc.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
# http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

McfFileVersion = 2

# Value for DISTRO
Distribution = 'webos'

# Supported MACHINE-s
Machines = ['raspberrypi3', 'qemux86']

# Layers = [
# (layer-name: str, priority: int, URL: str, fetch: dict, options: dict),
# ...
# ]
# Note that the github.com/openembedded repositories are read-only mirrors of
# the authoritative repositories on git.openembedded.org .
Layers = [
('bitbake',                   -1, 'git://github.com/openembedded/bitbake.git',              {'branch': '1.40', 'commit': '7c1eb51d'}, {}),

('meta-gplv2',                 1, 'git://git.yoctoproject.org/meta-gplv2',                  {'branch': 'thud', 'commit': 'aabc30f'}, {}),
('meta',                       5, 'git://github.com/openembedded/openembedded-core.git',    {'branch': 'thud', 'commit': 'f162d5bfe6'}, {}),

('meta-oe',                   10, 'git://github.com/openembedded/meta-openembedded.git',    {'branch': 'thud', 'commit': '9b3b907f30'}, {}),
('meta-multimedia',           11, 'git://github.com/openembedded/meta-openembedded.git',    {}, {}),
('meta-networking',           12, 'git://github.com/openembedded/meta-openembedded.git',    {}, {}),
('meta-python',               13, 'git://github.com/openembedded/meta-openembedded.git',    {}, {}),
('meta-filesystems',          14, 'git://github.com/openembedded/meta-openembedded.git',    {}, {}),

('meta-qt5-compat',           19, 'git://github.com/webosose/meta-webosose.git',            {}, {}),
('meta-qt5',                  20, 'git://github.com/meta-qt5/meta-qt5.git',                 {'branch': 'krogoth', 'commit': 'dcfcb58'}, {}),

('meta-webos-backports-2.7',  32, 'git://github.com/webosose/meta-webosose.git',            {}, {}),
('meta-webos-backports-2.8',  33, 'git://github.com/webosose/meta-webosose.git',            {}, {}),

('meta-ros2',                 38, 'git://github.com/lgsvl/meta-ros2.git',                   {'branch': 'master', 'commit': '577f371'}, {}),
('meta-webos',                40, 'git://github.com/webosose/meta-webosose.git',            {'branch': 'master', 'commit': '4e3ddd5'}, {}),

('meta-raspberrypi',          50, 'git://git.yoctoproject.org/meta-raspberrypi',            {'branch': 'thud', 'commit': 'c71d79e'}, {}),
('meta-webos-raspberrypi',    51, 'git://github.com/webosose/meta-webosose.git',            {}, {}),

('meta-webos-ros2',           52, 'git://github.com/webosose/meta-webosose.git',            {}, {}),
]

# BblayersConfExtraLines is a list of strings to be appended to the generated
# conf/bblayers.conf .
BblayersConfExtraLines = []
