require python-cbor.inc

inherit ${@bb.utils.contains("BBFILE_COLLECTIONS", "meta-python2", "setuptools", "", d)}

python() {
    if 'meta-python2' not in d.getVar('BBFILE_COLLECTIONS').split():
        raise bb.parse.SkipRecipe('Requires meta-python2 to be present.')
}

SRC_URI[md5sum] = "22b03b59784fd78cb6c27aa498af0db6"
SRC_URI[sha256sum] = "13225a262ddf5615cbd9fd55a76a0d53069d18b07d2e9f19c39e6acb8609bbb6"
