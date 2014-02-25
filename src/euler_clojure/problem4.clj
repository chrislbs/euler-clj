(ns euler-clojure.problem4
  (:require [clojure.string :as s]))

(defn is-palindrome? [number]
  (let [ value (str number)
         len (count value)
         a (subs value 0 (/ len 2))
         temp (subs value (/ (+ len 1) 2))
         b (s/reverse temp)]
    (= a b)))

(defn run []
  (reduce
    max 0
    (for [ x (range 100 1000)
           y (range 100 1000)
           :when (is-palindrome? (* x y))]
      (* x y))))
