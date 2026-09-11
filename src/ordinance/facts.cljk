(ns ordinance.facts
  "Municipal-ordinance compliance catalog for Ankara -- the
  THIRTY-SEVENTH municipality-level entry (see cloud-itonami-municipality-jpn-tokyo,
  -usa-washington-dc, -gbr-london, -can-toronto, -deu-berlin, -fra-paris,
  -nld-amsterdam, -esp-madrid, -kor-seoul, -ita-roma, -aus-sydney,
  -arg-buenos-aires, -fin-helsinki, -dnk-copenhagen, -nor-oslo,
  -bel-brussels, -chl-santiago, -col-bogota, -cri-san-jose,
  -bra-sao-paulo, -ury-montevideo, -zaf-cape-town, -ecu-quito,
  -swe-gothenburg, -pry-asuncion, -mex-guadalajara, -fra-lyon,
  -ind-new-delhi, -pol-warsaw, -ken-nairobi, -tha-bangkok, -are-abu-dhabi,
  -vnm-hanoi, -idn-jakarta, -phl-manila, -egy-cairo for the first
  thirty-six) per ADR-2607141700 (cloud-itonami-compliance-fact-federation).

  Ankara has been Turkey's stable capital since 29 October 1923
  (replacing Istanbul/Constantinople); no ongoing capital-transition
  ambiguity, unlike Egypt/Indonesia checked earlier this session.

  ankara.bel.tr (the municipality's own portal) returned HTTP 403 on
  every URL tried (both /meclis/kararlar and a council-decisions news
  page), so both entries here instead cite Turkey's national
  founding-charter-type laws that establish and currently govern
  Ankara's büyükşehir (metropolitan municipality) status, matching
  the pattern used for -ind-new-delhi/-pol-warsaw/-tha-bangkok/
  -are-abu-dhabi/-egy-cairo when a municipality's own domain was
  blocked or unreliable.

  Law No. 3030 of 1984 (adopted 27.6.1984, published in the Resmi
  Gazete 9.7.1984 Sayı 18453) -- the original law that granted Ankara
  (alongside Istanbul and Izmir) büyükşehir status -- title, number,
  and dates directly confirmed by reading the TBMM (Turkish Grand
  National Assembly) archive PDF's own first page via the Read-tool
  saved-path fallback (the WebFetch tool itself reported it as an
  illegible/binary PDF, a recurring font-subsetting pattern this
  session). Law No. 5216 of 2004 (adopted 10.7.2004, published in the
  Resmi Gazete 23.7.2004 Sayı 25531) -- the current, still-governing
  Büyükşehir Belediyesi Kanunu that superseded/updated 3030 -- title,
  number, and dates likewise directly confirmed by reading the TBMM
  archive PDF's own first page (mevzuat.gov.tr's own interactive page
  for this law confirmed the number/gazette date/issue but not the
  full title, so the TBMM archive PDF was used as the primary source
  for the title).

  An ordinance not in this table has NO spec-basis, full stop; extend
  `catalog`, do not invent an id/url/date.")

(def catalog
  "municipality-slug -> vector of ordinance entries."
  {"ankara"
   [{:ordinance/id "ankara.law-3030-1984-metropolitan-municipalities-administration"
     :ordinance/title "Büyük Şehir Belediyelerinin Yönetimi Hakkında Kanun Hükmünde Kararnamenin Değiştirilerek Kabulü Hakkında Kanun (Law on the Adoption with Amendments of the Decree Law on the Administration of Metropolitan Municipalities)"
     :ordinance/municipality "ankara"
     :ordinance/country "TUR"
     :ordinance/kind :local-act
     :ordinance/number "Kanun No. 3030"
     :ordinance/url "https://www5.tbmm.gov.tr/tutanaklar/KANUNLAR_KARARLAR/kanuntbmmc067/kanuntbmmc067/kanuntbmmc06703030.pdf"
     :ordinance/url-provenance :official-tbmm-gov-tr-archive
     :ordinance/enacted-date "1984-06-27"
     :ordinance/retrieved-at "2026-07-17"
     :ordinance/topic #{:governance}}
    {:ordinance/id "ankara.law-5216-2004-buyuksehir-belediyesi-kanunu"
     :ordinance/title "Büyükşehir Belediyesi Kanunu (Metropolitan Municipality Law)"
     :ordinance/municipality "ankara"
     :ordinance/country "TUR"
     :ordinance/kind :local-act
     :ordinance/number "Kanun No. 5216"
     :ordinance/url "https://www5.tbmm.gov.tr/tutanaklar/KANUNLAR_KARARLAR/kanuntbmmc088/kanuntbmmc088/kanuntbmmc08805216.pdf"
     :ordinance/url-provenance :official-tbmm-gov-tr-archive
     :ordinance/enacted-date "2004-07-10"
     :ordinance/retrieved-at "2026-07-17"
     :ordinance/topic #{:governance}}]})

(defn spec-basis [muni] (get catalog muni))

(defn coverage
  ([] (coverage (keys catalog)))
  ([munis]
   (let [have (filter catalog munis)
         missing (remove catalog munis)]
     {:requested (count munis)
      :covered (count have)
      :covered-municipalities (vec (sort have))
      :missing-municipalities (vec (sort missing))
      :note (str "cloud-itonami-municipality-tur-ankara Wave 0 (ADR-2607141700): "
                 (count (get catalog "ankara")) " Ankara entries seeded "
                 "with TBMM (Turkish Grand National Assembly) archive citations. "
                 "Extend `ordinance.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [muni topic]
  (filterv #(contains? (:ordinance/topic %) topic) (spec-basis muni)))
