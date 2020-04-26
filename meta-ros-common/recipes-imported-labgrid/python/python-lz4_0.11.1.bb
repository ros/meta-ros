require python-lz4.inc

inherit ${@bb.utils.contains("BBFILE_COLLECTIONS", "meta-python2", "setuptools", "", d)}

python() {
    if 'meta-python2' not in d.getVar('BBFILE_COLLECTIONS').split():
        raise bb.parse.SkipRecipe('Requires meta-python2 to be present.')
}

SRC_URI[md5sum] = "2a7d1d8669046c380ad69dbd9db4db94"
SRC_URI[sha256sum] = "440bbb039e15c09b049c0a8c1294978341d3fac943b83e04ff3f9e3b7ec0058b"
