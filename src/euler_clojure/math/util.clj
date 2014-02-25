(ns euler-clojure.math.util
  (:require [euler-clojure.math.prime :as prime])
  (:require [clojure.math.numeric-tower :as clj-math]))

; euclid's algorithm for solving GCD
; (http://en.wikipedia.org/wiki/Greatest_common_divisor)
(defn gcd [a b]
  (if (< a b)
    (recur b a)
    (if (zero? b)
      a
      (recur b, (mod a b)))))

(defn fib [a b]
  (cons a (lazy-seq (fib b (+ b a)))))

; get the most occurring factors from a collection of prime-factor-maps
(defn most-occuring-factors [factor-map-coll]
  (reduce
    (fn [highest-occurrence-map current-factor-map]
      (merge highest-occurrence-map
             (filter
               (fn [kvp]
                 (let [prime-num (get kvp 0)
                       prime-count (get kvp 1)]
                   (or
                     (not (contains? highest-occurrence-map prime-num))
                     (< (get highest-occurrence-map prime-num) prime-count))))
               current-factor-map)))
    {}
    factor-map-coll))

; least common multiple
(defn lcm
  ([a b] (clj-math/lcm a b))
  ([numbers]
   (reduce
     (fn [result kvp]
       (* result (clj-math/expt (get kvp 0) (get kvp 1))))
     1
     (most-occuring-factors
       (map
         prime/prime-factor-map
         numbers)))))

