LICENSE = "LGPL-2.1-or-later & BSD-3-Clause & LGPL-3.0-only & MIT & Zlib"
LIC_FILES_CHKSUM = "file://COPYING;md5=1de906ee96808d9776dd72a5f9a79a22 \
                    file://GIMPACT/GIMPACT-LICENSE-BSD.TXT;md5=8b8d3fd534c235edacef40718034070c \
                    file://GIMPACT/GIMPACT-LICENSE-LGPL.TXT;md5=b6606274a9090b4293304cdf242059bb \
                    file://LICENSE-BSD.TXT;md5=c74e6304a772117e059458fb9763a928 \
                    file://LICENSE.TXT;md5=771782cb6245c7fbbe74bc0ec059beff \
                    file://OPCODE/COPYING;md5=5ff3ce96fdfd6ab78b031640a9e33eff \
                    file://contrib/InteractiveCollisions/COPYING;md5=d32239bcb673463ab874e80d47fae504 \
                    file://contrib/InteractiveCollisions/deps/AntTweakBar/License.txt;md5=e5ac08a6307c2ae340b739fe7dc43f79 \
                    file://contrib/OdeModelProcessor/LICENSE-BSD.TXT;md5=026686d878a6e8ced3c571bb073bac92 \
                    file://contrib/OdeModelProcessor/LICENSE.TXT;md5=771782cb6245c7fbbe74bc0ec059beff \
                    file://libccd/BSD-LICENSE;md5=83141e9b5d6377b8cecbc00b0c454145 \
                    file://libccd/src/testsuites/cu/COPYING;md5=d32239bcb673463ab874e80d47fae504 \
                    file://libccd/src/testsuites/cu/COPYING.LESSER;md5=6a6a8e020838b23406c81b19c1d46df6 \
                    file://ou/LICENSE-BSD.TXT;md5=8bab2b7cb999c674805d70e66ae1c058 \
                    file://ou/LICENSE-LESSER.TXT;md5=228925258f0ad779adf7f9436cc23646 \
                    file://ou/LICENSE-ZLIB.TXT;md5=0c5593de9e2016a2c86bb7846506db97 \
                    file://ou/LICENSE.TXT;md5=664aa96239b59b044722945d56f70200 \
                    file://tests/UnitTest++/COPYING;md5=b0717d0dfa1369ef37aeca8f95384896"

SRC_URI = "git://bitbucket.org/odedevs/ode.git;protocol=https;branch=0.16.x"

PV = "0.16.5+git"
SRCREV = "cc5ca0e9417a8cf4000a63a5346c96eba0f5610b"

S = "${WORKDIR}/git"

PACKAGECONFIG ??= "${@bb.utils.filter('DISTRO_FEATURES', 'opengl', d)}"
PACKAGECONFIG[opengl] = "-DODE_WITH_DEMOS=ON,-DODE_WITH_DEMOS=OFF,virtual/libgl freeglut libx11"
PACKAGECONFIG[ccd] = "-DODE_WITH_LIBCCD=ON,-DODE_WITH_LIBCCD=OFF,ccd"

inherit cmake
