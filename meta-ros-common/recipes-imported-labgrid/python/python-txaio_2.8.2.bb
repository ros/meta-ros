require python-txaio.inc

inherit ${@bb.utils.contains("BBFILE_COLLECTIONS", "meta-python2", "setuptools", "", d)}

python() {
    if 'meta-python2' not in d.getVar('BBFILE_COLLECTIONS').split():
        raise bb.parse.SkipRecipe('Requires meta-python2 to be present.')
}

SRC_URI[md5sum] = "a20e3431c95896a49fa3ffa84f77cde1"
SRC_URI[sha256sum] = "484cd6c4cdd3f6081b87188f3b2b9a36e02fba6816e8256917c4f6571b567571"
