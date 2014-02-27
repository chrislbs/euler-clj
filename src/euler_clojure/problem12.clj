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

(def triangle-numbers
  (map first (iterate (fn [[sum num]] [(+ sum (inc num)) (inc num)]) [1 1])))

(defn run []
  (first
    (filter
      #(> (count (gen-factors %)) 500)
      triangle-numbers)))
