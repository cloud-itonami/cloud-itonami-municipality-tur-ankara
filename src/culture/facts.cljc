(ns culture.facts
  "Regional-culture catalog for Ankara -- local dishes, protected
  products, beverages, festivals and heritage sites, piggybacked
  onto this municipality compliance repo per ADR-2607171400
  (cloud-itonami-municipality-culture-catalog, in com-junkawasaki/root),
  sibling namespace to `ordinance.facts` (ADR-2607141700).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "municipality-slug -> vector of culture entries."
  {"ankara"
   [{:culture/id "ankara.dish.doner-kebab"
     :culture/name "Döner kebab"
     :culture/name-local "Döner kebap"
     :culture/municipality "ankara"
     :culture/country "TUR"
     :culture/kind :dish
     :culture/summary "Turkish dish of meat cooked on a vertical rotisserie, now widespread worldwide; the soslu dürüm variation is a specialty of Ankara."
     :culture/url "https://en.wikipedia.org/wiki/Doner_kebab"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "ankara.dish.kuru-fasulye"
     :culture/name "Kuru fasulye"
     :culture/municipality "ankara"
     :culture/country "TUR"
     :culture/kind :dish
     :culture/summary "Turkish stewed white-bean dish made with olive oil, onion and tomato paste, often considered the national dish of Turkey."
     :culture/url "https://en.wikipedia.org/wiki/Kuru_fasulye"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "ankara.dish.simit"
     :culture/name "Simit"
     :culture/municipality "ankara"
     :culture/country "TUR"
     :culture/kind :dish
     :culture/summary "Circular sesame-encrusted bread widespread in Turkey; simit in Ankara are smaller and crisper than those of other cities."
     :culture/url "https://en.wikipedia.org/wiki/Simit"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "ankara.dish.beypazari-kurusu"
     :culture/name "Beypazarı kurusu"
     :culture/municipality "ankara"
     :culture/country "TUR"
     :culture/kind :dish
     :culture/summary "Traditional hard biscuit from the Beypazarı district of Ankara Province, made with flour, milk, butter and cinnamon, typically served with tea."
     :culture/url "https://tr.wikipedia.org/wiki/Beypazar%C4%B1_kurusu"
     :culture/url-provenance :wikipedia-tr
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "ankara.product.angora-goat"
     :culture/name "Angora goat"
     :culture/name-local "Ankara keçisi"
     :culture/municipality "ankara"
     :culture/country "TUR"
     :culture/kind :product
     :culture/summary "Turkish goat breed named after Ankara, producing the lustrous fibre known as mohair."
     :culture/url "https://en.wikipedia.org/wiki/Angora_goat"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "ankara.beverage.kalecik-karasi"
     :culture/name "Kalecik Karası"
     :culture/municipality "ankara"
     :culture/country "TUR"
     :culture/kind :beverage
     :culture/summary "Turkish red wine grape variety named after the Kalecik district of Ankara Province, where it grows particularly well."
     :culture/url "https://en.wikipedia.org/wiki/Kalecik_Karas%C4%B1"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "ankara.beverage.ayran"
     :culture/name "Ayran"
     :culture/municipality "ankara"
     :culture/country "TUR"
     :culture/kind :beverage
     :culture/summary "Cold savory yogurt-based beverage consumed across Central Asia, the Balkans and the Middle East, promoted as Turkey's national drink."
     :culture/url "https://en.wikipedia.org/wiki/Ayran"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "ankara.heritage.anitkabir"
     :culture/name "Anıtkabir"
     :culture/municipality "ankara"
     :culture/country "TUR"
     :culture/kind :heritage
     :culture/summary "Mausoleum complex in Ankara's Çankaya district, the resting place of Mustafa Kemal Atatürk, founder and first President of the Turkish Republic."
     :culture/url "https://en.wikipedia.org/wiki/An%C4%B1tkabir"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "ankara.heritage.ankara-castle"
     :culture/name "Ankara Castle"
     :culture/name-local "Ankara Kalesi"
     :culture/municipality "ankara"
     :culture/country "TUR"
     :culture/kind :heritage
     :culture/summary "Historic fortification in the city of Ankara, with origins dating back to the 8th century BC."
     :culture/url "https://en.wikipedia.org/wiki/Ankara_Castle"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

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
      :note (str "cloud-itonami-municipality-tur-ankara culture catalog "
                 "(ADR-2607171400): " (count (get catalog "ankara"))
                 " Ankara entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [muni kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis muni)))
