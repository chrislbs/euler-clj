(ns euler-clojure.problem3
  (:require [euler-clojure.math.prime :as math-prime]))

(def the-number 600851475143)

(defn run [] (apply max (math-prime/prime-factors the-number)))
