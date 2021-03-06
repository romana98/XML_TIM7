<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:zcir="http://www.zahtevcir"
                xmlns:re="http://www.reusability"
                xmlns:fo="http://www.w3.org/1999/XSL/Format"
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
                        margin: 0%
                    }
                </style>
            </head>
            <body>
                    <div style="width: 37%; padding-left:30%">
                        <p style="font-family:Times New Roman; font-size:18px; text-align:center">
                            <xsl:value-of select="/zcir:zahtev/zcir:zahtev_body/zcir:ciljani_organ_vlasti"/>
                        </p>

                        <p style="font-family:Times New Roman; font-size:17px; text-align:center">
                            ...............................................................................................................
                        </p>

                        <p style="font-family:Times New Roman; font-size:14px; text-align:center">
                            назив и седиште органа коме се захтев упућује
                        </p>

                        <h1 style="font-family:Times New Roman;  text-align:center;padding-top:50px">
                            З А Х Т Е В
                        </h1>

                        <h2 style="font-family:Times New Roman;text-align:center">
                            за приступ информацији од јавног значаја
                        </h2>

                        <p style="font-family:Times New Roman; font-size:15px; text-align:justify;padding-top:15px" >
                            На основу члана 15. ст. 1. Закона о слободном приступу информацијама од јавног значаја
                            („Службени гласник РС“, бр. 120/04, 54/07, 104/09 и 36/10), од горе наведеног органа захтевам:*
                        </p>

                        <div style="margin-left:50px;padding-top:20px" >
                            <p style="font-family:Times New Roman; font-size:13px;" >
                                <xsl:for-each select="/zcir:zahtev/zcir:zahtev_body/zcir:tekst_zahteva/re:opcije/re:opcija">
                                    <p>
                                        <xsl:if test="@izabran='true'">
                                            <input type="checkbox" checked="true" disabled="true">
                                                <xsl:value-of select="."/>
                                            </input>
                                        </xsl:if>
                                    </p>
                                    <p>
                                        <xsl:if test="@izabran='false'">
                                            <input type="checkbox" disabled="true">
                                                <xsl:value-of select="."/>
                                            </input>
                                        </xsl:if>
                                    </p>
                                </xsl:for-each>
                            </p>
                        </div>

                        <div style="margin-left:65px" >
                            <p style="font-family:Times New Roman; font-size:13px;" >
                                <xsl:for-each select="/zcir:zahtev/zcir:zahtev_body/zcir:tekst_zahteva/re:opcije/re:nacini_dostave/re:nacin_dostave">
                                    <p>
                                        <xsl:if test="@izabran='true'">
                                            <input type="checkbox" checked="true" disabled="true">
                                                <xsl:value-of select="."/>
                                            </input>
                                        </xsl:if>
                                    </p>
                                    <p>
                                        <xsl:if test="@izabran='false'">
                                            <input type="checkbox"  disabled="true">
                                                <xsl:value-of select="."/>
                                            </input>
                                        </xsl:if>
                                    </p>
                                </xsl:for-each>
                            </p>
                        </div>

                        <p style="font-family:Times New Roman; font-size:15px;padding-top:25px;margin-left:50px" >
                            Овај захтев се односи на следеће информације:
                        </p>

                        <p style="font-family:Times New Roman; font-size:15px;padding-top:5px;margin-left:10px;text-indent: 40px" >
                            <xsl:value-of select="/zcir:zahtev/zcir:zahtev_body/zcir:tekst_zahteva/re:informacija_o_zahtevu"/>
                        </p>

                        <div style="padding-top:20px">
                            <div style="width:45%;float:left">
                                <p style="font-family:Times New Roman;text-align:justify; font-size:15px;padding-top:15px;margin-left:10px">
                                    У <xsl:value-of select="/zcir:zahtev/zcir:zahtev_body/zcir:mesto"/>,
                                </p>
                                <p style="font-family:Times New Roman;text-align:justify; font-size:15px;padding-top:15px;margin-left:10px">
                                    <xsl:value-of select="/zcir:zahtev/zcir:zahtev_body/@content"/> године.
                                </p>
                            </div>
                            <div style="font-family:Times New Roman;text-align:justify; font-size:15px;padding-top:15px;margin-left:10px;width:45%;float:right">
                                <p style="padding-top:10px">
                                    <xsl:value-of select="/zcir:zahtev/zcir:zahtev_body/zcir:informacije_o_traziocu/re:lice"/>
                                </p>
                                <p style="padding-top:10px">
                                    <xsl:value-of select="/zcir:zahtev/zcir:zahtev_body/zcir:informacije_o_traziocu/re:adresa"/>
                                    <xsl:value-of select="/zcir:zahtev/zcir:zahtev_body/zcir:informacije_o_traziocu/re:adresa/re:ulica/@broj"/>
                                </p>
                                <p style="padding-top:10px">
                                    <xsl:value-of select="/zcir:zahtev/zcir:zahtev_body/zcir:informacije_o_traziocu/re:drugi_podaci_za_kontakt"/>
                                </p>
                                <p style="padding-top:10px">
                                    _______________________
                                </p>
                                <p>
                                    Потпис
                                </p>

                            </div>
                        </div>

                        <div style="padding-top:200px;">
                            <p>
                                ________________________________________________________________
                            </p>
                            <p font-family="Times New Roman" font-size="9px">
                                * У кућици означити која законска права на приступ информацијама желите да остварите.
                            </p>
                            <p font-family="Times New Roman" font-size="9px">
                                ** У кућици означити начин достављања копије докумената.
                            </p>
                            <p font-family="Times New Roman" font-size="9px">
                                *** Када захтевате други начин достављања обавезно уписати који начин достављања захтевате.
                            </p>
                        </div>
                    </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
