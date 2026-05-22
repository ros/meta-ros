# Copyright (c) 2023 Wind River Systems, Inc.

# ERROR: QA Issue: /usr/lib/twist_mux/joystick_relay.py contained in package twist-mux requires /usr/bin/python3, but no providers found in RDEPENDS:twist-mux? [file-rdeps]
RDEPENDS:${PN} = "python3-core"
