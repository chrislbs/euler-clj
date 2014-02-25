(ns euler-clojure.problem6
  (:require [clojure.math.numeric-tower :as clj-math]))

(def natural-numbers 100)

(defn get-sums [upper-bound]
  (reduce
    (fn [kvp num]
      [(+ (get kvp 0) (* num num))
       (+ (get kvp 1) num)])
    [0 0]
    (range (+ upper-bound))))

(defn run []
  (let [sums (get-sums (+ 1 natural-numbers))]
    (- (clj-math/expt (get sums 1) 2) (get sums 0))))
