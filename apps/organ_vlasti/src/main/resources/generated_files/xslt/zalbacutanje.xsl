<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:zc="http://www.zalbacutanje"
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
                        margin: 0%
                    }
                </style>
            </head>
            <body>
                    <div style="width: 37%; padding-left:30%">
                        <p style="font-family:Times New Roman; font-size:16px; text-align:center" >
                            <b>ЖАЛБА КАДА ОРГАН ВЛАСТИ НИЈЕ ПОСТУПИО/ није поступио у целости/ ПО ЗАХТЕВУ ТРАЖИОЦА У ЗАКОНСКОМ  РОКУ  (ЋУТАЊЕ УПРАВЕ)</b>
                        </p>
                        <p  style="font-family:Times New Roman; font-size:16px;padding-top:10px;">
                            Повереникy за информације од јавног значаја и заштиту података о личности
                        </p>
                        <p  style="font-family:Times New Roman; font-size:16px;">
                            Адреса за пошту:  Београд, Булевар краља Александрa бр. 15
                        </p>
                        <p  style="font-family:Times New Roman; font-size:16px; padding-top:10px" >
                            У складу са чланом 22. Закона о слободном приступу информацијама од јавног значаја подносим:
                        </p>
                        <h2 style="font-family:Times New Roman;text-align:center">
                            Ж А Л Б У
                        </h2>
                        <h3  style="font-family:Times New Roman; text-align:center">
                            против
                        </h3>
                        <p style="font-family:Times New Roman; font-size:16px; text-align:center; padding-top:5px">
                            <xsl:value-of select="/zc:zalba_cutanje/zc:zalba_cutanje_body/zc:sadrzaj_zalbe/re:ciljani_organ_vlasti"/>
                        </p>
                        <p  style="font-family:Times New Roman; font-size:16px; text-align:center; padding-top:10px">
                            због тога што орган власти:
                        </p>
                        <p style="font-family:Times New Roman; font-size:16px; text-align:center; padding-top: 10px">
                            <xsl:for-each select="/zc:zalba_cutanje/zc:zalba_cutanje_body/zc:sadrzaj_zalbe/re:razlog_zalbe/re:opcija">
                                <xsl:if test="@izabran='true'">
                                   <b><xsl:value-of select="."/></b>
                                </xsl:if>
                            </xsl:for-each>
                        </p>


                        <p  style="font-family:Times New Roman; font-size:16px; text-align:justify; padding-top:15px">
                            по мом захтеву  за слободан приступ информацијама од јавног значаја који сам поднео  том органу  дана
                            <xsl:value-of select="/zc:zalba_cutanje/zc:zalba_cutanje_body/zc:sadrzaj_zalbe/re:datum"/>
                            године,
                            а којим сам тражио/ла да ми се у складу са Законом о слободном приступу информацијама од јавног значаја омогући увид-
                            копија документа који садржи информације  о /у вези са :
                        </p>
                        <p  style="font-family:Times New Roman; font-size:16px; text-align:justify; padding-top:10px">
                            <xsl:value-of select="/zc:zalba_cutanje/zc:zalba_cutanje_body/zc:sadrzaj_zalbe/re:podaci_o_zahtjevu_i_informacijama"/>
                        </p>
                        <p  style="font-family:Times New Roman; font-size:16px; text-align:justify; padding-top:10px">
                            На основу изнетог, предлажем да Повереник уважи моју жалбу и омогући ми приступ траженој/им  информацији/ма.
                        </p>
                        <p  style="font-family:Times New Roman; font-size:16px; text-align:justify">
                            Као доказ , уз жалбу достављам копију захтева са доказом о предаји органу власти.
                        </p>
                        <div  style="font-family:Times New Roman; font-size:16px; text-align:justify; padding-top: 10px">
                            <b>Напомена:</b> Код жалбе због непоступању по захтеву у целости, треба приложити и добијени
                        </div>
                        <div style="float:right;padding-top:10px">
                            <p>
                                <xsl:value-of select="/zc:zalba_cutanje/zc:zalba_cutanje_body/zc:podaci_o_podnosiocu/re:osoba"/>
                            </p>
                            <p>
                                <xsl:value-of select="/zc:zalba_cutanje/zc:zalba_cutanje_body/zc:podaci_o_podnosiocu/re:adresa"/>
                                <xsl:value-of select="/zc:zalba_cutanje/zc:zalba_cutanje_body/zc:podaci_o_podnosiocu/re:adresa/re:ulica/@broj"/>
                            </p>
                            <p>
                                <xsl:value-of select="/zc:zalba_cutanje/zc:zalba_cutanje_body/zc:podaci_o_podnosiocu/re:drugi_podaci_za_kontakt"/>
                            </p>
                            <p>
                                _________________
                            </p>
                            <p>
                                Потпис
                            </p>
                        </div>
                        <p   style="font-family:Times New Roman; font-size:16px; padding-top:100px">
                            У <xsl:value-of select="/zc:zalba_cutanje/zc:zalba_cutanje_body/zc:podaci_o_primaocu/re:adresa/re:mesto"/>,
                            дана <xsl:value-of select="/zc:zalba_cutanje/zc:zalba_cutanje_body/@content"/>
                        </p>
                    </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
