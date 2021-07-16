DESCRIPTION = "The AWS SDK for Python"
HOMEPAGE = "https://aws.amazon.com/sdk-for-python/"
AUTHOR = "Amazon Web Services"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

SRC_URI[md5sum] = "a18e37ff05d0dd0a59e43e7bcfd79469"
SRC_URI[sha256sum] = "b9c930982891229fe32c670c940835e4d5afcb52f60a5e512de8e5cba409900b"

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-botocore \
    ${PYTHON_PN}-jmespath \
    ${PYTHON_PN}-s3transfer \
"

inherit pypi
