(ns euler-clojure.problem5)

(defn run []
  (first (for [num (range) :when (evenly-divisible? num)] num)))
