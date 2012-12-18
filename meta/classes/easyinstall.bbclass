
pkg_postinst_${PN} () {
       if test ! -e ${PYTHON_SITEPACKAGES_DIR}/easy-install.pth; then
            cat > ${PYTHON_SITEPACKAGES_DIR}/easy-install.pth << EOF
import sys; sys.__plen = len(sys.path)
import sys; new=sys.path[sys.__plen:]; del sys.path[sys.__plen:]; p=getattr(sys,'__egginsert',0); sys.path[p:p]=new; sys.__egginsert = p+len(new)
EOF
        fi
        sed -i '$ i ${EASYINSTALL_${PN}}' ${PYTHON_SITEPACKAGES_DIR}/easy-install.pth
}

