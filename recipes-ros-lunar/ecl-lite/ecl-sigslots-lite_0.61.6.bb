DESCRIPTION = "This avoids use of dynamic storage (malloc/new) and thread \
  safety (mutexes) to provide a very simple sigslots implementation that can \
  be used for *very* embedded development."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "ecl-license ecl-config ecl-errors"

require ecl-lite.inc
