(ns euler-clojure.problem10
  (:require [euler-clojure.math.prime :as math-prime]))

(def upper-limit 2000000)

(defn run []
  (reduce + (math-prime/gen-primes upper-limit)))
