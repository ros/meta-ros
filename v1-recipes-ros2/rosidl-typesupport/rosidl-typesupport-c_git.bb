SUMMARY = "Generate the type support for C messages."
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=12c26a18c7f493fdc7e8a93b16b7c04f"
DEPENDS = "poco rosidl-generator-c rosidl-cmake"

include rosidl-typesupport.inc

SRC_URI += " \
    file://0001-Drop-poco_vendor-dependency.patch;patchdir=.. \
    file://0001-rosidl_typesupport_c-remove-redundant-target-linking.patch;patchdir=.. \
"
