(ns euler-clojure.problem9
  (:require [euler-clojure.math.util :as math-util])
  (:require [clojure.math.numeric-tower :as clj-math]))

(comment
  "A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

    a^2 + b^2 = c^2
  For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.

  There exists exactly one Pythagorean triplet for which a + b + c = 1000.
  Find the product abc.")

(def total-sum 1000)
;http://en.wikipedia.org/wiki/Pythagorean_triple#Generating_a_triple

(defn coprime? [a b]
  (= 1 (math-util/gcd a b)))

(defn primitive-triple? [m n]
  (and (odd? (- m n)) (coprime? m n)))

(defn make-triplet [k m n]
  [ (* k (- (clj-math/expt m 2) (clj-math/expt n 2)))
    (reduce * [2 m n k])
    (* k (+ (clj-math/expt m 2) (clj-math/expt n 2)))])

(defn triplets
  ([m n] (triplets 1 m n))
  ([k m n] (cons (make-triplet k m n) (lazy-seq (triplets (inc k) m n)))))

(defn run []
  (reduce
    *
    (first
      (filter
        #(= total-sum (reduce + %))
        (for [ m (map inc (range))
               n (range 1 m)
               :when (primitive-triple? m n)]
          (last
            (take-while
              #(<= (reduce + %) total-sum)
              (triplets m n))))))))
