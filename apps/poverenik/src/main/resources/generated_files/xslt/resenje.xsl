<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:ra="http://resenje"
                xmlns:re="http://www.reusability"
                version="2.0">

    <xsl:template match="/">
        <html>
            <head>
                <title>Obavestenje</title>
                <style type="text/css">
                    html {
                        font-family: Times New Roman;
                    }
                    p {
                        margin: 0%;
                        font-size="13px"
                    }
                </style>
            </head>
            <body>
                    <div style="width: 37%; padding-left:30%">
                        <p style="text-align:justify" >
                            Примери поступања Повереника по жалби
                        </p>
                        <p style="text-align:justify"  >
                            ______________________________________________________________________
                        </p>
                        <p>
                            Решење када је жалба
                            <xsl:value-of select="/ra:resenje/ra:resenje_body/ra:tip_resenja"/>
                            – налаже се:
                        </p>
                        <div style="float: left; width:35%">
                                <p>
                                    Бр.
                                    <xsl:value-of select="/ra:resenje/ra:resenje_body/@broj"/>
                                </p>
                        </div>
                        <div style="width:35%;float: right">
                                <p>
                                    Датум
                                    <xsl:value-of select="/ra:resenje/ra:resenje_body/@content"/>
                                    године.
                                </p>
                        </div>

                        <p style="padding-top:30px;text-align:justify;">
                            <xsl:value-of select="/ra:resenje/ra:resenje_body/ra:uvodne_informacije"/>
                        </p>

                        <h2  style="text-align:center"  >
                            Р Е Ш Е Њ Е
                        </h2>

                        <div style="text-align:justify;">
                            <xsl:for-each select="/ra:resenje/ra:resenje_body/ra:podaci_o_resenju/ra:tacka">
                                <p>
                                    <xsl:value-of select="."/>
                                </p>
                            </xsl:for-each>
                        </div>

                        <h2 style="text-align:center">
                            О Б Р А З Л О Ж Е Њ Е
                        </h2>

                        <div style="text-align:justify" >
                            <xsl:for-each select="/ra:resenje/ra:resenje_body/ra:podaci_o_obrazlozenju/*">
                                <xsl:if test="position() > 1">
                                    <p>
                                        <xsl:value-of select="."/>
                                    </p>
                                </xsl:if>
                            </xsl:for-each>
                        </div>

                        <div style="float:right">
                            <p>ПОВЕРЕНИК</p>
                            <p><xsl:value-of select="/ra:resenje/ra:resenje_body/ra:poverenik"/></p>
                        </div>

                        <div>
                            <a href="{/ra:resenje/ra:resenje_body/@link_na_zalbu}">Референцирана жалба</a>
                        </div>
                    </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
