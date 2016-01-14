EXTRA_OECONF += "\
  --enable-ipv6 \
"

RDEPENDS_${PN}-distutils += "${PN}-email"
