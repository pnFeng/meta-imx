# Copyright (C) 2016 Freescale Semiconductor
# Copyright 2017-2022 NXP
# Copyright 2018 (C) O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "G2D library using i.MX GPU"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://COPYING;md5=5a0bf11f745e68024f37b4724a5364fe" 
DEPENDS = "libgal-imx"
PROVIDES = "virtual/libg2d"

FSLBIN_NAME = "${PN}-${PV}-${TARGET_ARCH}"

SRC_URI = "${FSL_MIRROR}/${FSLBIN_NAME}.bin;name=${TARGET_ARCH};fsl-eula=true"
SRC_URI[aarch64.md5sum] = "9c95f91ffa6718c2e2a943914c2ca6a7"
SRC_URI[aarch64.sha256sum] = "a618ce341c48e3c624a060c5a5600b0608368b3c67b03276ec5dfec3c6e0f0df"
SRC_URI[arm.md5sum] = "cea531605d112d961854f0e2535f4f33"
SRC_URI[arm.sha256sum] = "2e086856d909c84ca99ce220f5856498de61bcda4960dcc673a715134232fe99"

S = "${WORKDIR}/${FSLBIN_NAME}"

inherit fsl-eula-unpack

do_install () {
    install -d ${D}${libdir}
    install -d ${D}${includedir}
    cp -r ${S}/g2d/usr/lib/*.so* ${D}${libdir}
    cp -Pr ${S}/g2d/usr/include/* ${D}${includedir}
}

INSANE_SKIP:${PN} = "ldflags"

COMPATIBLE_MACHINE = "(imxgpu2d)"
