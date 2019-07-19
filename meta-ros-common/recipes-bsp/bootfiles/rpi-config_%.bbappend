# Copyright (c) 2019 LG Electronics, Inc.

# Assume video camera support will always be wanted on Raspberry Pi-s (see
# https://meta-raspberrypi.readthedocs.io/en/latest/extra-build-config.html#video-camera-support-with-v4l2-drivers). It does no
# harm to build with this set even when there is no camera attached, but "just in case" use ??= so it can be overridden.
VIDEO_CAMERA ??= "1"
