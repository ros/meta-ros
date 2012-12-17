inherit distutils-base

DISTUTILS_BUILD_ARGS ?= ""
DISTUTILS_STAGE_HEADERS_ARGS ?= "--install-dir=${STAGING_INCDIR}/${PYTHON_DIR}"
DISTUTILS_STAGE_ALL_ARGS ?= "--prefix=${STAGING_DIR_HOST}${prefix} \
    --install-data=${STAGING_DATADIR}"
DISTUTILS_INSTALL_ARGS ?= "--prefix=${D}/${prefix} \
    --install-data=${D}/${datadir}"

distutils_do_compile() {
         STAGING_INCDIR=${STAGING_INCDIR} \
         STAGING_LIBDIR=${STAGING_LIBDIR} \
         BUILD_SYS=${BUILD_SYS} HOST_SYS=${HOST_SYS} \
         ${STAGING_BINDIR_NATIVE}/python-native/python setup.py build ${DISTUTILS_BUILD_ARGS} || \
         bbfatal "python setup.py build_ext execution failed."
}

distutils_stage_headers() {
        install -d ${STAGING_DIR_HOST}${PYTHON_SITEPACKAGES_DIR}
        BUILD_SYS=${BUILD_SYS} HOST_SYS=${HOST_SYS} \
        ${STAGING_BINDIR_NATIVE}/python-native/python setup.py install_headers ${DISTUTILS_STAGE_HEADERS_ARGS} || \
        bbfatal "python setup.py install_headers execution failed."
}

distutils_stage_all() {
        STAGING_INCDIR=${STAGING_INCDIR} \
        STAGING_LIBDIR=${STAGING_LIBDIR} \
        install -d ${STAGING_DIR_HOST}${PYTHON_SITEPACKAGES_DIR}
        PYTHONPATH=${STAGING_DIR_HOST}${PYTHON_SITEPACKAGES_DIR} \
        BUILD_SYS=${BUILD_SYS} HOST_SYS=${HOST_SYS} \
        ${STAGING_BINDIR_NATIVE}/python-native/python setup.py install ${DISTUTILS_STAGE_ALL_ARGS} || \
        bbfatal "python setup.py install (stage) execution failed."
}

distutils_do_install() {
        install -d ${D}${PYTHON_SITEPACKAGES_DIR}
        STAGING_INCDIR=${STAGING_INCDIR} \
        STAGING_LIBDIR=${STAGING_LIBDIR} \
        PYTHONPATH=${D}/${PYTHON_SITEPACKAGES_DIR} \
        BUILD_SYS=${BUILD_SYS} HOST_SYS=${HOST_SYS} \
        ${STAGING_BINDIR_NATIVE}/python-native/python setup.py install --install-lib=${D}/${PYTHON_SITEPACKAGES_DIR} ${DISTUTILS_INSTALL_ARGS} || \
        bbfatal "python setup.py install execution failed."

        for i in `find ${D} -name "*.py"` ; do \
            sed -i -e s:${D}::g $i
        done

        if test -e ${D}${bindir} ; then	
            for i in ${D}${bindir}/* ; do \
                sed -i -e s:${STAGING_BINDIR_NATIVE}/python-native/python:${bindir}/python:g $i
                sed -i -e s:${STAGING_BINDIR_NATIVE}:${bindir}:g $i
            done
        fi

        if test -e ${D}${sbindir}; then
            for i in ${D}${sbindir}/* ; do \
                sed -i -e s:${STAGING_BINDIR_NATIVE}/python-native/python:${bindir}/python:g $i
                sed -i -e s:${STAGING_BINDIR_NATIVE}:${bindir}:g $i
            done
        fi

        rm -f ${D}${PYTHON_SITEPACKAGES_DIR}/easy-install.pth
        
        #
        # FIXME: Bandaid against wrong datadir computation
        #
        if test -e ${D}${datadir}/share; then
            mv -f ${D}${datadir}/share/* ${D}${datadir}/
        fi
}

pkg_postinst_${PN} () {
	if test ! -e ${PYTHON_SITEPACKAGES_DIR}/easy-install.pth; then
            cat > ${PYTHON_SITEPACKAGES_DIR}/easy-install.pth << EOF
import sys; sys.__plen = len(sys.path)
import sys; new=sys.path[sys.__plen:]; del sys.path[sys.__plen:]; p=getattr(sys,'__egginsert',0); sys.path[p:p]=new; sys.__egginsert = p+len(new)
EOF
        fi
        sed -i '$ i ${EASYINSTALL_${PN}}' ${PYTHON_SITEPACKAGES_DIR}/easy-install.pth
}

EXPORT_FUNCTIONS do_compile do_install

export LDSHARED="${CCLD} -shared"
