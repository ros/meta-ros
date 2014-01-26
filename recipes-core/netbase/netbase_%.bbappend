do_install_prepend () {
	sed -i -e "$ i\
127.0.0.1	${hostname}.localdomain	${hostname}" ${WORKDIR}/hosts
}

inherit hostname
