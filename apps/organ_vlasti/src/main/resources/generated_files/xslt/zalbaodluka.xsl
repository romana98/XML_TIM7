<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:zoc="http://www.zalbanaodlukucir"
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
                <div style="width: 37%; padding-left:30%;font-family:Times New Roman">
                    <p style="font-size:15px;text-align:center; font-weight:bold" >
                        ЖАЛБА  ПРОТИВ  ОДЛУКЕ ОРГАНА  ВЛАСТИ КОЈОМ ЈЕ
                        ОДБИЈЕН ИЛИ ОДБАЧЕН ЗАХТЕВ ЗА ПРИСТУП ИНФОРМАЦИЈИ
                    </p>
                    <p style="font-size:15px;font-weight:bold;padding-top:10px">
                        Повереникy за информације од јавног значаја и заштиту података о личности
                    </p>
                    <p style="font-size:15px" >
                        Адреса за пошту:  Београд, Булевар краља Александрa бр. 15
                    </p>
                    <h2 style="padding-top:17px;text-align:center">
                        Ж А Л Б А
                    </h2>
                    <p style="padding-top:15px;font-size:16px;font-weight:bold;text-align:center">
                        <xsl:value-of select="/zoc:zalba_odluka/zoc:zalba_odluka_body/zoc:zalilac/re:tip_lica/re:osoba"/>
                        <xsl:value-of select="/zoc:zalba_odluka/zoc:zalba_odluka_body/zoc:zalilac/re:sediste_zalioca"/>
                        <xsl:value-of select="/zoc:zalba_odluka/zoc:zalba_odluka_body/zoc:zalilac/re:adresa/re:ulica"/>
                        <xsl:value-of select="/zoc:zalba_odluka/zoc:zalba_odluka_body/zoc:zalilac/re:adresa/re:ulica/@broj"/>
                    </p>
                    <p style="font-size:16px;text-align:center">
                        (Име, презиме, односно назив,седиште жалиоца и адреса)
                    </p>
                    <p style="padding-top:15px;font-size:16px;text-align:center">
                        против решења-закључка
                    </p>
                    <p style="padding-top:15px;font-size:16px;font-weight:bold;text-align:center">
                        <xsl:value-of select="/zoc:zalba_odluka/zoc:zalba_odluka_body/zoc:protiv_resenja_zakljucka/re:naziv_organa_koji_je_doneo_odluku"/>
                    </p>
                    <p style="font-size:16px;text-align:center" >
                        (назив органа који је донео одлуку)
                    </p>
                    <p  style="padding-top:15px;font-size:16px;text-align:justify">
                        Број
                        <xsl:value-of select="/zoc:zalba_odluka/zoc:zalba_odluka_body/zoc:protiv_resenja_zakljucka/re:broj"/>
                        од
                        <xsl:value-of select="/zoc:zalba_odluka/zoc:zalba_odluka_body/zoc:protiv_resenja_zakljucka/re:od_godine"/>
                        године.
                    </p>
                    <p style="padding-top:15px;font-size:16px;text-align:justify">
                        Наведеном одлуком органа власти (решењем, закључком, обавештењем у писаној форми са елементима
                        одлуке) , супротно закону, одбијен-одбачен је мој захтев који сам поднео/ла-упутио/ла дана
                        <xsl:value-of select="/zoc:zalba_odluka/zoc:zalba_odluka_body/zoc:sadrzaj/re:datum"/>
                        године и тако ми ускраћено-онемогућено остваривање уставног и законског права на слободан
                        приступ информацијама од јавног значаја. Oдлуку побијам у целости, односно у делу којим.
                        <xsl:value-of select="/zoc:zalba_odluka/zoc:zalba_odluka_body/zoc:sadrzaj/re:osnova_za_zalbu"/>
                        јер није заснована на Закону о слободном приступу информацијама од јавног значаја.
                    </p>
                    <p style="padding-top:15px;font-size:16px;text-align:justify">
                        На основу изнетих разлога, предлажем да Повереник уважи моју жалбу,  поништи одлука првостепеног
                        органа и омогући ми приступ траженој/им  информацији/ма.
                    </p>
                    <p style="padding-top:15px;font-size:16px;text-align:justify">
                        Жалбу подносим благовремено, у законском року утврђеном у члану 22. ст. 1.
                        Закона о слободном приступу информацијама од јавног значаја.
                    </p>

                    <div style="width=50%;float:right;padding-top:20px">
                        <p style="padding-top:5px" >
                            <xsl:value-of select="/zoc:zalba_odluka/zoc:zalba_odluka_body/zoc:podaci_o_podnosiocu_zalbe/re:osoba"/>
                        </p>
                        <p style="padding-top:5px" >
                            <xsl:value-of select="/zoc:zalba_odluka/zoc:zalba_odluka_body/zoc:podaci_o_podnosiocu_zalbe/re:adresa"/>
                            <xsl:value-of select="/zoc:zalba_odluka/zoc:zalba_odluka_body/zoc:podaci_o_podnosiocu_zalbe/re:adresa/re:ulica/@broj"/>
                        </p>
                        <p style="padding-top:5px" >
                            <xsl:value-of select="/zoc:zalba_odluka/zoc:zalba_odluka_body/zoc:podaci_o_podnosiocu_zalbe/re:drugi_podaci_za_kontakt"/>
                        </p>
                        <p style="padding-top:5px" >
                            _________________
                        </p>
                        <p>
                            Потпис
                        </p>
                    </div>

                    <div style="font-size:15px;height:150px;padding-top:20px"  >
                        У <xsl:value-of select="/zoc:zalba_odluka/zoc:zalba_odluka_body/zoc:zalilac/re:sediste_zalioca"/>,
                        дана <xsl:value-of select="/zoc:zalba_odluka/zoc:zalba_odluka_body/@content"/>
                    </div>

                    <p style="font-size:15px">
                        Напомена:
                    </p>
                    <p style="font-size:15px">
                        •	У жалби се мора навести одлука која се побија (решење, закључак, обавештење),
                        назив органа који је одлуку донео, као и број и датум одлуке. Довољно је да жалилац
                        наведе у жалби у ком погледу је незадовољан одлуком, с тим да жалбу не мора посебно образложити.
                        Ако жалбу изјављује на овом обрасцу, додатно образложење може  посебно приложити.
                    </p>
                    <p style="font-size:15px">
                        •	Уз жалбу обавезно приложити копију поднетог захтева и доказ о његовој предаји-упућивању
                        органу као и копију одлуке органа која се оспорава жалбом.
                    </p>
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
