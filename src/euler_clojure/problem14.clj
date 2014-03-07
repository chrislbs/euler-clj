(ns euler-clojure.problem14)

(defn collatz-sequence [num]
  (concat
    (take-while
      #(not= 1 %)
      (iterate
        (fn [n]
          (if (odd? n) (+ 1 (* 3 n)) (quot n 2)))
        num
        ))
    (list 1)))

(def upper-limit 10000)

(defn run []
  (reduce
    (fn [prev, cur] (if (> (get cur 1) (get prev 1)) cur prev))
    (map
      (fn [num] [num (count (collatz-sequence num))])
      (range 1 upper-limit))))
