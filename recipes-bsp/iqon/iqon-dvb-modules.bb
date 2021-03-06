DESCRIPTION = "Hardware drivers for ${MACHINE}"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"

SRCDATE = "20130917"
KV = "3.5.3"
PV = "${KV}+${SRCDATE}"
PR = "r2"

RCONFLICTS_${PN} = "technomate-dvb-modules"
RREPLACES_${PN} = "technomate-dvb-modules"

SRC_URI = "http://en2.ath.cx/release/images/oedrivers/bcmlinuxdvb_7335-${KV}-${SRCDATE}.tar.gz"

S = "${WORKDIR}"

INHIBIT_PACKAGE_STRIP = "1"

inherit module

do_compile() {
}

do_install() {
	install -d ${D}/lib/modules/${KV}/extra
	for f in lib/modules/${KV}/extra/*.ko; do
		install -m 0644 $f ${D}/$f;
	done
	install -d ${D}/${sysconfdir}/modules-load.d
	for i in `ls ${D}/lib/modules/${KV}/extra | grep \\.ko | sed -e 's/.ko//g'`; do
		echo $i _hwtype=\$hwtypenum >> ${D}/${sysconfdir}/modules-load.d/_${MACHINE}.conf
	done
}

SRC_URI[md5sum] = "530f9c3d1ff8e5ff0b920e0e5851295a"
SRC_URI[sha256sum] = "12b4c1e609ce660741a40d75d6f149bc40aa31dbb236883571bbc7c71fe386b1"
