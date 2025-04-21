# Copyright (c) 2023 Wind River Systems, Inc.

SRC_URI += "https://artifactory.kinovaapps.com:443/artifactory/generic-public/kortex/API/2.5.0/linux_x86-64_x86_gcc.zip;name=zip;subdir=git/kinova_binary_api" 
SRC_URI[zip.md5sum] = "64bd86e7ab8bda90ef1fc7d6a356e080"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
  file://0001-use-bitbake-fetcher.patch \
  file://0002-install-libraries.patch \
"
