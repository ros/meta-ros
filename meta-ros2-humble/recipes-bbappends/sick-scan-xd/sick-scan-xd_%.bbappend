_LICENSE := "${LICENSE}"
LICENSE = "${@'${_LICENSE}'.replace('Apache-License,-Version-2.0,-see-"http-www.apache.org-licenses-LICENSE-2.0"', 'Apache-2.0')}"
