(ns euler-clojure.problem7
  (:require [euler-clojure.math.prime :as math-prime]))

(def prime-to-fetch 10001)

(defn run []
  (last (take prime-to-fetch (math-prime/gen-primes 1000000))))
