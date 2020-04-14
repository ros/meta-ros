# Blacklist python2 and all recipes depending on it
ROS_WORLD_SKIP_GROUPS += "python2"

PNBLACKLIST[python] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'ROS 2 is Python 3 only', '', d)}"

# These depends on python directly:
# meta-openembedded/meta-oe/recipes-connectivity/gammu/gammu_1.32.0.bb
PNBLACKLIST[gammu] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-connectivity/thrift/thrift_0.9.3.bb
PNBLACKLIST[thrift] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-dbs/mongodb/mongodb_git.bb
PNBLACKLIST[mongodb] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-dbs/mysql/mysql-python_1.2.5.bb
PNBLACKLIST[mysql-python] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-dbs/postgresql/postgresql_10.10.bb
PNBLACKLIST[postgresql] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-devtools/mercurial/mercurial_4.6.1.bb
PNBLACKLIST[mercurial] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-devtools/python/python-cpuset_1.5.7.bb
PNBLACKLIST[python-cpuset] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-devtools/python/python-distutils-extra.bb
PNBLACKLIST[python-distutils-extra] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-devtools/python/python-futures_3.2.0.bb
PNBLACKLIST[python-futures] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-devtools/python/python-pygobject_3.28.3.bb
PNBLACKLIST[python-pygobject] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-devtools/sip/sip_4.19.13.bb
PNBLACKLIST[sip] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-extended/hplip/hplip_3.12.6.bb
PNBLACKLIST[hplip] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-extended/iotop/iotop_0.6.bb
PNBLACKLIST[iotop] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-extended/konkretcmpi/konkretcmpi_0.9.2.bb
PNBLACKLIST[konkretcmpi] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-extended/libimobiledevice/libplist_2.0.0.bb
PNBLACKLIST[libplist] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-extended/rrdtool/rrdtool_1.7.0.bb
PNBLACKLIST[rrdtool] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-extended/sanlock/sanlock_3.6.0.bb
PNBLACKLIST[sanlock] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-gnome/pyxdg/pyxdg_0.26.bb
PNBLACKLIST[pyxdg] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-graphics/fontforge/fontforge_20170731.bb
PNBLACKLIST[fontforge] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-security/nmap/nmap_7.70.bb
PNBLACKLIST[nmap] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-support/libiio/libiio_git.bb
PNBLACKLIST[libiio] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-support/lio-utils/lio-utils_4.1.bb
PNBLACKLIST[lio-utils] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-support/pidgin/pidgin_2.12.0.bb
PNBLACKLIST[pidgin] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-test/cxxtest/cxxtest_4.3.bb
PNBLACKLIST[cxxtest] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-connectivity/gateone/gateone_git.bb
PNBLACKLIST[gateone] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-connectivity/python-gsocketpool/python-gsocketpool_0.1.6.bb
PNBLACKLIST[python-gsocketpool] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-connectivity/python-mprpc/python-mprpc_0.1.16.bb
PNBLACKLIST[python-mprpc] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-connectivity/python-pyconnman/python-pyconnman_0.1.0.bb
PNBLACKLIST[python-pyconnman] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-connectivity/python-pyro4/python-pyro4_4.73.bb
PNBLACKLIST[python-pyro4] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-connectivity/python-pytun/python-pytun_2.2.1.bb
PNBLACKLIST[python-pytun] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-connectivity/python-thrift/python-thrift_0.11.0.bb
PNBLACKLIST[python-thrift] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-connectivity/python-txws/python-txws_0.9.1.bb
PNBLACKLIST[python-txws] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/pyrtm_0.4.2.bb
PNBLACKLIST[pyrtm] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-alembic_1.0.0.bb
PNBLACKLIST[python-alembic] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-anyjson_0.3.3.bb
PNBLACKLIST[python-anyjson] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-appdirs_1.4.3.bb
PNBLACKLIST[python-appdirs] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-asn1crypto_0.24.0.bb
PNBLACKLIST[python-asn1crypto] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-astroid_1.6.5.bb
PNBLACKLIST[python-astroid] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-attr_0.3.1.bb
PNBLACKLIST[python-attr] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-attrs_18.1.0.bb
PNBLACKLIST[python-attrs] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-automat_0.7.0.bb
PNBLACKLIST[python-automat] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-aws-iot-device-sdk-python_1.4.0.bb
PNBLACKLIST[python-aws-iot-device-sdk-python] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-babel_2.6.0.bb
PNBLACKLIST[python-babel] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-backports-abc_0.4.bb
PNBLACKLIST[python-backports-abc] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-backports-functools-lru-cache_1.5.bb
PNBLACKLIST[python-backports-functools-lru-cache] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-backports-ssl_3.5.0.1.bb
PNBLACKLIST[python-backports-ssl] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-bcrypt_3.1.4.bb
PNBLACKLIST[python-bcrypt] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-beautifulsoup4_4.6.0.bb
PNBLACKLIST[python-beautifulsoup4] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-behave_1.2.6.bb
PNBLACKLIST[python-behave] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-bitarray_0.8.3.bb
PNBLACKLIST[python-bitarray] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-blinker_1.4.bb
PNBLACKLIST[python-blinker] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-can_2.2.1.bb
PNBLACKLIST[python-can] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-certifi_2018.8.13.bb
PNBLACKLIST[python-certifi] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-cffi_1.11.5.bb
PNBLACKLIST[python-cffi] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-chardet_3.0.4.bb
PNBLACKLIST[python-chardet] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-cheetah_2.4.4.bb
PNBLACKLIST[python-cheetah] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-click_6.7.bb
PNBLACKLIST[python-click] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-cmd2_0.9.2.bb
PNBLACKLIST[python-cmd2] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-configparser_3.5.0.bb
PNBLACKLIST[python-configparser] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-constantly_15.1.0.bb
PNBLACKLIST[python-constantly] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-crcmod_1.7.bb
PNBLACKLIST[python-crcmod] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-cryptography-vectors_2.3.bb
PNBLACKLIST[python-cryptography-vectors] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-cryptography_2.3.bb
PNBLACKLIST[python-cryptography] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-cython_0.28.5.bb
PNBLACKLIST[python-cython] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-daemon_2.1.2.bb
PNBLACKLIST[python-daemon] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-daemonize_2.4.7.bb
PNBLACKLIST[python-daemonize] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-dateutil_2.7.3.bb
PNBLACKLIST[python-dateutil] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-dbus_1.2.8.bb
PNBLACKLIST[python-dbus] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-dbusmock_0.16.7.bb
PNBLACKLIST[python-dbusmock] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-decorator_4.3.0.bb
PNBLACKLIST[python-decorator] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-django-south_1.0.2.bb
PNBLACKLIST[python-django-south] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-django_1.11.14.bb
PNBLACKLIST[python-django] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-djangorestframework_3.9.0.bb
PNBLACKLIST[python-djangorestframework] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-dnspython_1.15.0.bb
PNBLACKLIST[python-dnspython] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-docutils_0.14rc2.bb
PNBLACKLIST[python-docutils] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-dominate_2.3.1.bb
PNBLACKLIST[python-dominate] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-editor_1.0.3.bb
PNBLACKLIST[python-editor] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-enum34_1.1.6.bb
PNBLACKLIST[python-enum34] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-epydoc_3.0.1.bb
PNBLACKLIST[python-epydoc] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-evdev_0.7.0.bb
PNBLACKLIST[python-evdev] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-feedformatter_0.4.bb
PNBLACKLIST[python-feedformatter] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-feedparser_5.2.1.bb
PNBLACKLIST[python-feedparser] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-flask-babel_0.11.2.bb
PNBLACKLIST[python-flask-babel] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-flask-bcrypt_0.7.1.bb
PNBLACKLIST[python-flask-bcrypt] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-flask-bootstrap_3.3.7.1.bb
PNBLACKLIST[python-flask-bootstrap] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-flask-login_0.4.1.bb
PNBLACKLIST[python-flask-login] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-flask-mail_0.9.1.bb
PNBLACKLIST[python-flask-mail] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-flask-migrate_2.2.1.bb
PNBLACKLIST[python-flask-migrate] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-flask-nav_0.6.bb
PNBLACKLIST[python-flask-nav] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-flask-navigation_0.2.0.bb
PNBLACKLIST[python-flask-navigation] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-flask-pymongo_0.5.1.bb
PNBLACKLIST[python-flask-pymongo] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-flask-restful_0.3.6.bb
PNBLACKLIST[python-flask-restful] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-flask-script_2.0.6.bb
PNBLACKLIST[python-flask-script] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-flask-sijax_0.4.1.bb
PNBLACKLIST[python-flask-sijax] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-flask-sqlalchemy_2.3.2.bb
PNBLACKLIST[python-flask-sqlalchemy] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-flask-uploads_0.2.1.bb
PNBLACKLIST[python-flask-uploads] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-flask-user_0.6.19.bb
PNBLACKLIST[python-flask-user] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-flask-wtf_0.14.2.bb
PNBLACKLIST[python-flask-wtf] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-flask-xstatic_0.0.1.bb
PNBLACKLIST[python-flask-xstatic] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-flask_1.0.2.bb
PNBLACKLIST[python-flask] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-funcsigs_1.0.2.bb
PNBLACKLIST[python-funcsigs] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-functools32_3.2.3-2.bb
PNBLACKLIST[python-functools32] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-future_0.16.0.bb
PNBLACKLIST[python-future] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-gdata_2.0.18.bb
PNBLACKLIST[python-gdata] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-gevent_1.2.2.bb
PNBLACKLIST[python-gevent] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-greenlet_0.4.14.bb
PNBLACKLIST[python-greenlet] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-grpcio-tools_1.14.1.bb
PNBLACKLIST[python-grpcio-tools] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-grpcio_1.14.1.bb
PNBLACKLIST[python-grpcio] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-html5lib_1.0.1.bb
PNBLACKLIST[python-html5lib] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-humanize_0.5.1.bb
PNBLACKLIST[python-humanize] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-hyperlink_18.0.0.bb
PNBLACKLIST[python-hyperlink] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-idna_2.7.bb
PNBLACKLIST[python-idna] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-imaging_1.1.7.bb
PNBLACKLIST[python-imaging] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-incremental_17.5.0.bb
PNBLACKLIST[python-incremental] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-inflection_0.3.1.bb
PNBLACKLIST[python-inflection] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-intervals_1.5.4.bb
PNBLACKLIST[python-intervals] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-ipaddress_1.0.22.bb
PNBLACKLIST[python-ipaddress] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-iso8601_0.1.12.bb
PNBLACKLIST[python-iso8601] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-isort_4.3.4.bb
PNBLACKLIST[python-isort] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-itsdangerous_0.24.bb
PNBLACKLIST[python-itsdangerous] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-javaobj-py3_0.2.4.bb
PNBLACKLIST[python-javaobj-py3] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-jinja2_2.10.bb
PNBLACKLIST[python-jinja2] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-jsonpatch_1.23.bb
PNBLACKLIST[python-jsonpatch] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-jsonpointer_2.0.bb
PNBLACKLIST[python-jsonpointer] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-jsonschema_2.6.0.bb
PNBLACKLIST[python-jsonschema] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-lazy-object-proxy_1.3.1.bb
PNBLACKLIST[python-lazy-object-proxy] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-linecache2_1.0.0.bb
PNBLACKLIST[python-linecache2] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-lockfile_0.12.2.bb
PNBLACKLIST[python-lockfile] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-lxml_4.2.4.bb
PNBLACKLIST[python-lxml] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-m2crypto_0.30.1.bb
PNBLACKLIST[python-m2crypto] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-mako_1.0.7.bb
PNBLACKLIST[python-mako] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-markupsafe_1.0.bb
PNBLACKLIST[python-markupsafe] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-mccabe_0.4.0.bb
PNBLACKLIST[python-mccabe] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-mock_2.0.0.bb
PNBLACKLIST[python-mock] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-monotonic_1.5.bb
PNBLACKLIST[python-monotonic] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-msgpack_0.5.6.bb
PNBLACKLIST[python-msgpack] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-ndg-httpsclient_0.5.1.bb
PNBLACKLIST[python-ndg-httpsclient] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-netaddr_0.7.19.bb
PNBLACKLIST[python-netaddr] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-networkx_2.1.bb
PNBLACKLIST[python-networkx] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-numeric_24.2.bb
PNBLACKLIST[python-numeric] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-oauthlib_2.0.6.bb
PNBLACKLIST[python-oauthlib] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-paho-mqtt_1.3.1.bb
PNBLACKLIST[python-paho-mqtt] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pandas_0.23.4.bb
PNBLACKLIST[python-pandas] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-parse-type_0.4.2.bb
PNBLACKLIST[python-parse-type] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-parse_1.8.4.bb
PNBLACKLIST[python-parse] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-passlib_1.7.1.bb
PNBLACKLIST[python-passlib] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-paste_2.0.3.bb
PNBLACKLIST[python-paste] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pbr_4.2.0.bb
PNBLACKLIST[python-pbr] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pep8_1.7.1.bb
PNBLACKLIST[python-pep8] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-periphery_1.1.1.bb
PNBLACKLIST[python-periphery] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pexpect_4.6.0.bb
PNBLACKLIST[python-pexpect] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pint_0.8.1.bb
PNBLACKLIST[python-pint] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pip_18.0.bb
PNBLACKLIST[python-pip] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pluggy_0.6.0.bb
PNBLACKLIST[python-pluggy] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-ply_3.11.bb
PNBLACKLIST[python-ply] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pretend_1.0.9.bb
PNBLACKLIST[python-pretend] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-prettytable_0.7.2.bb
PNBLACKLIST[python-prettytable] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-progress_1.4.bb
PNBLACKLIST[python-progress] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-prompt-toolkit_2.0.4.bb
PNBLACKLIST[python-prompt-toolkit] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-protobuf_3.6.1.bb
PNBLACKLIST[python-protobuf] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-psutil_5.4.6.bb
PNBLACKLIST[python-psutil] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-ptyprocess_0.6.0.bb
PNBLACKLIST[python-ptyprocess] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-py_1.6.0.bb
PNBLACKLIST[python-py] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pyalsaaudio_0.8.4.bb
PNBLACKLIST[python-pyalsaaudio] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pyasn1-modules_0.2.2.bb
PNBLACKLIST[python-pyasn1-modules] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pyasn1_0.4.4.bb
PNBLACKLIST[python-pyasn1] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pybind11_2.2.3.bb
PNBLACKLIST[python-pybind11] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pybluez_0.22.bb
PNBLACKLIST[python-pybluez] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pycodestyle_2.4.0.bb
PNBLACKLIST[python-pycodestyle] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pycparser_2.18.bb
PNBLACKLIST[python-pycparser] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pycrypto_2.6.1.bb
PNBLACKLIST[python-pycrypto] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pycryptodome_3.4.11.bb
PNBLACKLIST[python-pycryptodome] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pydbus_0.6.0.bb
PNBLACKLIST[python-pydbus] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pyexpect_1.0.17.bb
PNBLACKLIST[python-pyexpect] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pyfirmata_1.0.3.bb
PNBLACKLIST[python-pyfirmata] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pyflakes_1.6.0.bb
PNBLACKLIST[python-pyflakes] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pyflame_1.6.6.bb
PNBLACKLIST[python-pyflame] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pygpgme_0.3.bb
PNBLACKLIST[python-pygpgme] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pyhamcrest_1.9.0.bb
PNBLACKLIST[python-pyhamcrest] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pyiface_0.0.11.bb
PNBLACKLIST[python-pyiface] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pyinotify_0.9.6.bb
PNBLACKLIST[python-pyinotify] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pyjks_17.1.1.bb
PNBLACKLIST[python-pyjks] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pyjwt_1.6.4.bb
PNBLACKLIST[python-pyjwt] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pylint_1.8.3.bb
PNBLACKLIST[python-pylint] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pymisp_2.4.93.bb
PNBLACKLIST[python-pymisp] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pymongo_3.7.1.bb
PNBLACKLIST[python-pymongo] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pynetlinux_1.1.bb
PNBLACKLIST[python-pynetlinux] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pyopenssl_18.0.0.bb
PNBLACKLIST[python-pyopenssl] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pyparsing_2.2.0.bb
PNBLACKLIST[python-pyparsing] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pyperclip_1.6.2.bb
PNBLACKLIST[python-pyperclip] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pyrex_0.9.9.bb
PNBLACKLIST[python-pyrex] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pyroute2_0.5.2.bb
PNBLACKLIST[python-pyroute2] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pyserial_3.4.bb
PNBLACKLIST[python-pyserial] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pysmi_0.2.2.bb
PNBLACKLIST[python-pysmi] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pysnmp_4.3.5.bb
PNBLACKLIST[python-pysnmp] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pysocks_1.6.8.bb
PNBLACKLIST[python-pysocks] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pysqlite_2.8.3.bb
PNBLACKLIST[python-pysqlite] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pystache_0.5.4.bb
PNBLACKLIST[python-pystache] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pytest-helpers-namespace_2016.7.10.bb
PNBLACKLIST[python-pytest-helpers-namespace] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pytest-runner_4.2.bb
PNBLACKLIST[python-pytest-runner] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pytest-tempdir_2016.8.20.bb
PNBLACKLIST[python-pytest-tempdir] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pytest_3.4.2.bb
PNBLACKLIST[python-pytest] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pytz_2018.5.bb
PNBLACKLIST[python-pytz] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pyudev_0.21.0.bb
PNBLACKLIST[python-pyudev] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pyusb_1.0.2.bb
PNBLACKLIST[python-pyusb] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pyyaml_3.13.bb
PNBLACKLIST[python-pyyaml] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pyzmq_17.1.0.bb
PNBLACKLIST[python-pyzmq] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-redis_2.10.6.bb
PNBLACKLIST[python-redis] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-requests_2.19.1.bb
PNBLACKLIST[python-requests] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-rfc3987_1.3.7.bb
PNBLACKLIST[python-rfc3987] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-robotframework-seriallibrary_0.3.1.bb
PNBLACKLIST[python-robotframework-seriallibrary] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-robotframework_3.0.4.bb
PNBLACKLIST[python-robotframework] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-scrypt_0.8.6.bb
PNBLACKLIST[python-scrypt] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-sdnotify_0.3.2.bb
PNBLACKLIST[python-sdnotify] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-selectors34_1.2.bb
PNBLACKLIST[python-selectors34] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-semver_2.8.1.bb
PNBLACKLIST[python-semver] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-serpent_1.25.bb
PNBLACKLIST[python-serpent] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-setuptools-scm_2.1.0.bb
PNBLACKLIST[python-setuptools-scm] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-sh_1.12.14.bb
PNBLACKLIST[python-sh] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-sijax_0.3.2.bb
PNBLACKLIST[python-sijax] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-simplejson_3.16.0.bb
PNBLACKLIST[python-simplejson] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-singledispatch_3.4.0.3.bb
PNBLACKLIST[python-singledispatch] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-six_1.11.0.bb
PNBLACKLIST[python-six] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-slip-dbus_0.6.1.bb
PNBLACKLIST[python-slip-dbus] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-smbus_4.0.bb
PNBLACKLIST[python-smbus] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-snakefood_1.4.bb
PNBLACKLIST[python-snakefood] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-snimpy_0.8.12.bb
PNBLACKLIST[python-snimpy] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-sparts_0.7.3.bb
PNBLACKLIST[python-sparts] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-speaklater_1.3.bb
PNBLACKLIST[python-speaklater] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-sqlalchemy_1.1.17.bb
PNBLACKLIST[python-sqlalchemy] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-stevedore_1.29.0.bb
PNBLACKLIST[python-stevedore] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-strict-rfc3339_0.7.bb
PNBLACKLIST[python-strict-rfc3339] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-subprocess32_3.2.7.bb
PNBLACKLIST[python-subprocess32] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-systemd_234.bb
PNBLACKLIST[python-systemd] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-tornado-redis_2.4.18.bb
PNBLACKLIST[python-tornado-redis] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-tornado_5.1.bb
PNBLACKLIST[python-tornado] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-traceback2_1.4.0.bb
PNBLACKLIST[python-traceback2] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-twisted_18.4.0.bb
PNBLACKLIST[python-twisted] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-twofish_0.3.0.bb
PNBLACKLIST[python-twofish] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-typing_3.6.4.bb
PNBLACKLIST[python-typing] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-ujson_1.35.bb
PNBLACKLIST[python-ujson] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-unidiff_0.5.5.bb
PNBLACKLIST[python-unidiff] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-urllib3_1.23.bb
PNBLACKLIST[python-urllib3] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-vcversioner_2.16.0.0.bb
PNBLACKLIST[python-vcversioner] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-visitor_0.1.3.bb
PNBLACKLIST[python-visitor] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-vobject_0.9.6.1.bb
PNBLACKLIST[python-vobject] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-wcwidth_0.1.7.bb
PNBLACKLIST[python-wcwidth] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-webcolors_1.8.1.bb
PNBLACKLIST[python-webcolors] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-webdav_0.1.2.bb
PNBLACKLIST[python-webdav] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-webencodings_0.5.1.bb
PNBLACKLIST[python-webencodings] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-werkzeug_0.14.1.bb
PNBLACKLIST[python-werkzeug] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-whoosh_2.7.4.bb
PNBLACKLIST[python-whoosh] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-wrapt_1.10.11.bb
PNBLACKLIST[python-wrapt] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-wtforms_2.2.1.bb
PNBLACKLIST[python-wtforms] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-xlrd_1.1.0.bb
PNBLACKLIST[python-xlrd] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-xstatic-font-awesome_4.7.0.0.bb
PNBLACKLIST[python-xstatic-font-awesome] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-xstatic_1.0.1.bb
PNBLACKLIST[python-xstatic] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-yappi_0.98.bb
PNBLACKLIST[python-yappi] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-zopeinterface_4.5.0.bb
PNBLACKLIST[python-zopeinterface] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python3-robotframework-seriallibrary_0.3.1.bb
PNBLACKLIST[python3-robotframework-seriallibrary] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-extended/python-cson/python-cson_git.bb
PNBLACKLIST[python-cson] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-extended/python-pyephem/python-pyephem_3.7.6.0.bb
PNBLACKLIST[python-pyephem] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-extended/python-pyparted/python-pyparted_3.11.1.bb
PNBLACKLIST[python-pyparted] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-extended/pywbem/python-pywbem_0.11.0.bb
PNBLACKLIST[python-pywbem] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-raspberrypi/recipes-devtools/python/python-rtimu_git.bb
PNBLACKLIST[python-rtimu] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-raspberrypi/recipes-devtools/python/python-sense-hat_2.2.0.bb
PNBLACKLIST[python-sense-hat] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-ros/meta-ros-backports-zeus/recipes-devtools/python/python-packaging_19.2.bb
PNBLACKLIST[python-packaging] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-ros/meta-ros-common/recipes-devtools/python/python-defusedxml_0.5.0.bb
PNBLACKLIST[python-defusedxml] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-ros/meta-ros-common/recipes-devtools/python/python-ecdsa_0.13.bb
PNBLACKLIST[python-ecdsa] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-ros/meta-ros-common/recipes-devtools/python/python-empy_3.3.2.bb
PNBLACKLIST[python-empy] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-ros/meta-ros-common/recipes-devtools/python/python-gnupg_0.4.1.bb
PNBLACKLIST[python-gnupg] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-ros/meta-ros-common/recipes-devtools/python/python-matplotlib_2.1.1.bb
PNBLACKLIST[python-matplotlib] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-ros/meta-ros-common/recipes-devtools/python/python-netifaces_0.10.5.bb
PNBLACKLIST[python-netifaces] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-ros/meta-ros-common/recipes-devtools/python/python-paramiko_1.16.0.bb
PNBLACKLIST[python-paramiko] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-ros/meta-ros-common/recipes-devtools/python/python-pillow_5.1.0.bb
PNBLACKLIST[python-pillow] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-ros/meta-ros-common/recipes-devtools/python/python-pyproj_1.9.6.bb
PNBLACKLIST[python-pyproj] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-ros/meta-ros-common/recipes-devtools/python/python-sphinx_1.6.7.bb
PNBLACKLIST[python-sphinx] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-ros/meta-ros-common/recipes-extended/wxwidgets/wxpython_3.0.2.0.bb
PNBLACKLIST[wxpython] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-ros/meta-ros-common/recipes-imported-iot-cloud/python/python-boto3_1.10.25.bb
PNBLACKLIST[python-boto3] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-ros/meta-ros-common/recipes-imported-iot-cloud/python/python-botocore_1.13.26.bb
PNBLACKLIST[python-botocore] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-ros/meta-ros-common/recipes-imported-iot-cloud/python/python-jmespath_0.9.3.bb
PNBLACKLIST[python-jmespath] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-ros/meta-ros-common/recipes-imported-iot-cloud/python/python-s3transfer_0.2.1.bb
PNBLACKLIST[python-s3transfer] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-ros/meta-ros-common/recipes-imported-jupyter/python-pydot/python-pydot_1.4.1.bb
PNBLACKLIST[python-pydot] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-ros/meta-ros-common/recipes-infrastructure/python/python-catkin-pkg_0.4.15.bb
PNBLACKLIST[python-catkin-pkg] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-ros/meta-ros-common/recipes-infrastructure/python/python-rosdep_0.16.1.bb
PNBLACKLIST[python-rosdep] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-ros/meta-ros-common/recipes-infrastructure/python/python-rosdistro_0.8.0.bb
PNBLACKLIST[python-rosdistro] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-ros/meta-ros-common/recipes-infrastructure/python/python-rosinstall_0.7.8.bb
PNBLACKLIST[python-rosinstall] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-ros/meta-ros-common/recipes-infrastructure/python/python-rospkg_1.1.10.bb
PNBLACKLIST[python-rospkg] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-ros/meta-ros-common/recipes-infrastructure/python/python-vcstools_0.1.42.bb
PNBLACKLIST[python-vcstools] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-ros/meta-ros-common/recipes-infrastructure/python/python-wstool_0.1.17.bb
PNBLACKLIST[python-wstool] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# openembedded-core/meta/recipes-devtools/python-numpy/python-numpy_1.14.5.bb
PNBLACKLIST[python-numpy] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# openembedded-core/meta/recipes-devtools/python/python-nose_1.3.7.bb
PNBLACKLIST[python-nose] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# openembedded-core/meta/recipes-devtools/python/python-scons_3.0.1.bb
PNBLACKLIST[python-scons] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# openembedded-core/meta/recipes-devtools/python/python-setuptools_40.0.0.bb
PNBLACKLIST[python-setuptools] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-raspberrypi/recipes-devtools/python/rpi-gpio_0.6.3.bb
PNBLACKLIST[rpi-gpio] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-raspberrypi/recipes-devtools/python/rpio_0.10.0.bb
PNBLACKLIST[rpio] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# openembedded-core/meta/recipes-extended/asciidoc/asciidoc_8.6.9.bb
PNBLACKLIST[asciidoc] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-benchmark/fio/fio_3.12.bb
PNBLACKLIST[fio] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-benchmark/phoronix-test-suite/phoronix-test-suite_8.0.1.bb
PNBLACKLIST[phoronix-test-suite] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-support/pcsc-lite/pcsc-lite_1.8.22.bb
PNBLACKLIST[pcsc-lite] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-benchmark/libhugetlbfs/libhugetlbfs_git.bb
PNBLACKLIST[libhugetlbfs] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# openembedded-core/meta/recipes-kernel/linux/kernel-devsrc.bb
PNBLACKLIST[kernel-devsrc] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-connectivity/lirc/lirc_0.9.4d.bb
PNBLACKLIST[lirc] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# openembedded-core/meta/recipes-kernel/perf/perf.bb
PNBLACKLIST[perf] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-ros/meta-ros-backports-dunfell/recipes-devtools/python/python-pycryptodomex_3.9.3.bb
PNBLACKLIST[python-pycryptodomex] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"

# The rest depends on something which depends on python:
# meta-openembedded/meta-oe/recipes-bsp/lm_sensors/lmsensors_3.4.0.bb
PNBLACKLIST[lmsensors] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-connectivity/libimobiledevice/libimobiledevice_git.bb
PNBLACKLIST[libimobiledevice] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-core/packagegroups/packagegroup-meta-oe.bb
PNBLACKLIST[packagegroup-meta-oe] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['world-issues', 'world-svn-fetcher', 'python2'], 'world-issues: Depends on blacklisted packages like ndctl; world-svn-fetcher: Depends on blacklisted packages like s3c24xx-gpio, s3c64xx-gpio, wmiconfig, usbpath; python2: Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-dbs/psqlodbc/psqlodbc_09.05.0300.bb
PNBLACKLIST[psqlodbc] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-extended/openlmi/openlmi-tools_0.10.5.bb
PNBLACKLIST[openlmi-tools] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-support/pidgin/pidgin-otr_4.0.2.bb
PNBLACKLIST[pidgin-otr] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-connectivity/telepathy/telepathy-python_0.15.19.bb
PNBLACKLIST[telepathy-python] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python3-m2crypto_0.30.1.bb
PNBLACKLIST[python3-m2crypto] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-raspberrypi/recipes-core/packagegroups/packagegroup-rpi-test.bb
PNBLACKLIST[packagegroup-rpi-test] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['world-issues', 'python2'], 'world-issues: Depends on blacklisted packages like wiringpi and recipes from meta-multimedia we do not depend on: bigbuckbunny-480p, bigbuckbunny-720p, bigbuckbunny-1080p and wireless-regdb from meta-networking; python2: Depends on blacklisted python2', '', d)}"
# meta-ros/meta-ros-common/recipes-devtools/python/python-tornado45_git.bb
PNBLACKLIST[python-tornado45] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-ros/meta-ros-common/recipes-extended/bullet/bullet_2.87.bb
PNBLACKLIST[bullet] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-bsp/lm_sensors/lmsensors-config_1.0.bb
PNBLACKLIST[lmsensors-config] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-extended/collectd/collectd_5.8.0.bb
PNBLACKLIST[collectd] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-extended/libimobiledevice/libusbmuxd_git.bb
PNBLACKLIST[libusbmuxd] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-graphics/openbox/openbox_3.6.1.bb
PNBLACKLIST[openbox] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-benchmark/s-suite/s-suite_git.bb
PNBLACKLIST[s-suite] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-connectivity/usbmuxd/usbmuxd_git.bb
PNBLACKLIST[usbmuxd] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-extended/lcdproc/lcdproc_git.bb
PNBLACKLIST[lcdproc] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-support/ccid/ccid_1.4.24.bb
PNBLACKLIST[ccid] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-support/openct/openct_0.6.20.bb
PNBLACKLIST[openct] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-support/opensc/opensc_0.18.0.bb
PNBLACKLIST[opensc] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# openembedded-core/meta/recipes-core/packagegroups/packagegroup-core-tools-profile.bb
PNBLACKLIST[packagegroup-core-tools-profile] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-support/freerdp/freerdp_git.bb
PNBLACKLIST[freerdp] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-benchmark/analyze-suspend/analyze-suspend_git.bb
PNBLACKLIST[analyze-suspend] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-devtools/nodejs/nodejs_8.12.0.bb
PNBLACKLIST[nodejs] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-extended/cfengine/cfengine-masterfiles_3.12.0.bb
PNBLACKLIST[cfengine-masterfiles] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-support/dstat/dstat_0.7.3.bb
PNBLACKLIST[dstat] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-support/smem/smem_1.4.bb
PNBLACKLIST[smem] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# openembedded-core/meta/recipes-extended/ltp/ltp_20180515.bb
PNBLACKLIST[ltp] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-extended/cfengine/cfengine_3.12.0.bb
PNBLACKLIST[cfengine] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"

# More recipes since warrior:
# meta-openembedded/meta-oe/recipes-devtools/guider/guider_3.9.4.bb
PNBLACKLIST[guider] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-cachetools_3.1.0.bb
PNBLACKLIST[python-cachetools] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-engineio_3.5.0.bb
PNBLACKLIST[python-engineio] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-flask-socketio_3.3.2.bb
PNBLACKLIST[python-flask-socketio] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-isodate_0.6.0.bb
PNBLACKLIST[python-isodate] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-rdflib_4.2.2.bb
PNBLACKLIST[python-rdflib] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-requests-oauthlib_0.8.0.bb
PNBLACKLIST[python-requests-oauthlib] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-socketio_4.0.0.bb
PNBLACKLIST[python-socketio] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-tqdm_4.31.1.bb
PNBLACKLIST[python-tqdm] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-twitter_3.7.0.bb
PNBLACKLIST[python-twitter] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-tzlocal_1.5.1.bb
PNBLACKLIST[python-tzlocal] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# openembedded-core/meta/recipes-core/packagegroups/packagegroup-core-tools-testapps.bb
PNBLACKLIST[packagegroup-core-tools-testapps] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['world-license', 'python2'], 'world-license: depends on gst-examples which depends on gstreamer1.0-plugins-bad which depends on faad2 which has a restricted license not whitelisted in LICENSE_FLAGS_WHITELIST; python: depends on python2', '', d)}"

# More recipes since zeus:
# meta-openembedded/meta-oe/recipes-devtools/python/python-jsmin_2.2.2.bb
PNBLACKLIST[python-jsmin] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-devtools/python/python-pytoml_0.1.21.bb
PNBLACKLIST[python-pytoml] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-devtools/python/python-which_1.1.0.bb
PNBLACKLIST[python-which] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-support/pidgin/funyahoo-plusplus_git.bb
PNBLACKLIST[funyahoo-plusplus] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-support/pidgin/icyque_git.bb
PNBLACKLIST[icyque] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-support/pidgin/pidgin-sipe_1.24.0.bb
PNBLACKLIST[pidgin-sipe] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-support/pidgin/purple-skypeweb_git.bb
PNBLACKLIST[purple-skypeweb] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-oe/recipes-support/remmina/remmina_1.3.6.bb
PNBLACKLIST[remmina] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['world-issues', 'python2'], 'world-issues: Depends on spice, spice-protocol from meta-networking, fixed in dunfell: http://git.openembedded.org/meta-openembedded/commit/?id=876f4ce7639def476664834acafbf87cc227fb05; python2: Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python-jsonref/python-jsonref_0.2.bb
PNBLACKLIST[python-jsonref] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-atomicwrites_1.3.0.bb
PNBLACKLIST[python-atomicwrites] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-coloredlogs_10.0.bb
PNBLACKLIST[python-coloredlogs] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-humanfriendly_4.18.bb
PNBLACKLIST[python-humanfriendly] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-importlib-metadata_0.23.bb
PNBLACKLIST[python-importlib-metadata] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-lrparsing_1.0.16.bb
PNBLACKLIST[python-lrparsing] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-more-itertools_5.0.0.bb
PNBLACKLIST[python-more-itertools] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pathlib2_2.3.4.bb
PNBLACKLIST[python-pathlib2] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pika_1.1.0.bb
PNBLACKLIST[python-pika] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pycurl_7.43.0.3.bb
PNBLACKLIST[python-pycurl] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pymysql_0.9.3.bb
PNBLACKLIST[python-pymysql] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pyperf_1.6.1.bb
PNBLACKLIST[python-pyperf] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-pyrsistent_0.15.4.bb
PNBLACKLIST[python-pyrsistent] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-statistics_1.0.3.5.bb
PNBLACKLIST[python-statistics] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-toml_0.10.0.bb
PNBLACKLIST[python-toml] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-versiontools_1.9.1.bb
PNBLACKLIST[python-versiontools] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-waitress_1.3.1.bb
PNBLACKLIST[python-waitress] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
# meta-openembedded/meta-python/recipes-devtools/python/python-zipp_0.6.0.bb
PNBLACKLIST[python-zipp] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python2', 'Depends on blacklisted python2', '', d)}"
