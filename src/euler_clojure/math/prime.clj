(ns euler-clojure.math.prime
  (:import java.util.ArrayList)
  (:import java.util.Collections))

; Generates primes using the http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
(defn gen-primes [max]
  (let [ is-prime-array(new java.util.ArrayList (Collections/nCopies max true ))
         upper-limit (Math/sqrt max)]

    (doseq [x (range 2 upper-limit)]
      (if-not (false? (.get is-prime-array (- x 1)))
         ; mark all multiples as non-prime
        (doseq [y (range (+ x x) (.size is-prime-array) x)]
          (.set is-prime-array (- y 1) false))))

    (filter
      #(true? (.get is-prime-array (- % 1)))
      (range 2 max))))

(defn multiple? [n div]
  (= 0 (mod n div)))

; stolen from https://github.com/pgambling
(defn prime-factors
  ([num] (prime-factors num 2 []))
  ([num i factors]
   (cond
     (= 1 num) factors
     (multiple? num i) (recur (/ num i) i (conj factors i))
     :else (recur num (inc i) factors))))

; prime factor frequency map e.g. num = 8, result: { 2 3 }
(defn prime-factor-map [num] (frequencies (prime-factors num)))
