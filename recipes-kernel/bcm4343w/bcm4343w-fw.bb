DESCRIPTION = "Firmware files for use with BCM4343w wifi"
S = "${WORKDIR}/git/brcm80211"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=8cba1397cda6386db37210439a0da3eb"

PV = "0.43"
PR = "r0"

PROVIDES += "bcm4343w-fw"

SRC_URI = "git://github.com/RPi-Distro/firmware-nonfree.git;protocol=git;branch=master \
		file://bcm43430a1.hcd"
SRCREV = "a7491de4c4b2f1ceb5d0dfa5350b95e5c6fb9bd4"

do_install() {
	install -d ${D}/lib/firmware/brcm
	install -d ${D}/lib/firmware/bcm
	install -m 0755 ${S}/brcm/* ${D}/lib/firmware/brcm/
	install -m 0755 ${WORKDIR}/bcm43430a1.hcd ${D}/lib/firmware/bcm/bcm43430a1.hcd
	install -m 0644 ${S}/LICENSE ${D}/lib/firmware/bcm/
	install -m 0644 ${S}/LICENSE ${D}/lib/firmware/brcm/
}

FILES_${PN} =  "/lib/firmware/brcm/*"
FILES_${PN} += "/lib/firmware/bcm/bcm43430a1.hcd"
FILES_${PN} += "/lib/firmware/bcm/LICENSE"

