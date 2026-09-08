(ns culture.facts-test
  (:require [clojure.edn :as edn]
            [kotoba.lang.text :as str]
            [clojure.test :refer [deftest is]]
            [culture.facts :as facts]))

(deftest ankara-has-culture-basis
  (let [sb (facts/spec-basis "ankara")]
    (is (= 9 (count sb)))
    (is (= (count sb) (count (set (map :culture/id sb)))))
    (is (every? #(str/starts-with? (:culture/url %) "https://") sb))
    (is (every? #(= "ankara" (:culture/municipality %)) sb))
    (is (every? #(= "TUR" (:culture/country %)) sb))
    (is (every? #(seq (:culture/summary %)) sb))
    (is (every? #(string? (:culture/retrieved-at %)) sb))))

(deftest unknown-municipality-has-no-basis
  (is (nil? (facts/spec-basis "istanbul")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["ankara" "istanbul"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["istanbul"] (:missing-municipalities c)))))

(deftest by-kind-filters
  (is (= 4 (count (facts/by-kind "ankara" :dish))))
  (is (= ["ankara.product.angora-goat"]
         (mapv :culture/id (facts/by-kind "ankara" :product))))
  (is (empty? (facts/by-kind "ankara" :craft)))
  (is (empty? (facts/by-kind "istanbul" :dish))))

(deftest tx-file-matches-catalog
  (let [tx (edn/read-string (slurp "data/culture-tx.edn"))
        flat (mapcat val (sort-by key facts/catalog))]
    (is (= (vec flat) (vec tx)))))
