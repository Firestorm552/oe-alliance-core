DESCIPTION = "S3 set eth0 wol"
MAINTAINER = "vuplus team"
LICENSE = "CLOSED"

PV = "1.0"
PR = "r0"

SRC_URI = "file://ethwol.sh"

inherit update-rc.d
INITSCRIPT_NAME = "ethwol"
INITSCRIPT_PARAMS = "stop 32 0 ."

do_install() {
	install -d ${D}/etc/init.d ${D}/usr/bin
	install -m 0755 ${WORKDIR}/ethwol.sh ${D}/etc/init.d/ethwol
}
