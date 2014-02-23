(ns euler-clojure.math.util)

; euclid's algorithm for solving GCD
; (http://en.wikipedia.org/wiki/Greatest_common_divisor)
(defn gcd [a b]
  (if (< a b)
    (recur b a)
    (if (zero? b)
      a
      (recur b, (mod a b)))))

; least common multiples of two numbers
(defn lcm [a b]
  (/ (Math/abs (* a b)) (gcd a b)))
