(ns euler-clojure.problem2
  (:require [euler-clojure.math.util :as math-util]))

(def max-number 4000000)

(defn run[]
  (reduce
    +
    (take-while #(< % max-number) (filter even? (math-util/fib 1 1)))))
