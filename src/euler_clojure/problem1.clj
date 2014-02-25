(ns euler-clojure.problem1)

(def the-numbers (range 1000))

(defn is-a-multiple? [v]
  (or (= 0 (mod v 3)) (= 0 (mod v 5))))

(defn sum-multiples [sum number]
  (if (is-a-multiple? number)
    (+ sum number)
    sum))

(defn run []
  (reduce sum-multiples 0 the-numbers))
