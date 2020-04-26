require python-py-ubjson.inc

inherit ${@bb.utils.contains("BBFILE_COLLECTIONS", "meta-python2", "setuptools", "", d)}

python() {
    if 'meta-python2' not in d.getVar('BBFILE_COLLECTIONS').split():
        raise bb.parse.SkipRecipe('Requires meta-python2 to be present.')
}

SRC_URI[md5sum] = "ce17e26420f663edcd4962957dbcaa33"
SRC_URI[sha256sum] = "81784e64936c12e218afc49ff4fb90702f298ac16848971d9570c87595860762"
