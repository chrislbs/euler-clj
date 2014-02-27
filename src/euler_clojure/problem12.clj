(ns euler-clojure.problem12
  (:require [euler-clojure.math.prime :as math-prime])
  (:require [clojure.math.combinatorics :as combo]))

(defn gen-factors [num]
  (conj
    (map
      #(reduce * %)
      (distinct
        (filter
          #(not-empty %)
          (combo/subsets (math-prime/prime-factors num)))))
    1 ))

(defn num-divisors [num]
  (* 2 (count (filter #(zero? (rem num %)) (range 1 (Math/sqrt num))))))

(def triangle-numbers
  (map first (iterate (fn [[sum num]] [(+ sum (inc num)) (inc num)]) [1 1])))

(defn run []
  (first
    (filter
      #(> (num-divisors %) 500)
      ;#(> (count (gen-factors %)) 500)
      triangle-numbers)))
