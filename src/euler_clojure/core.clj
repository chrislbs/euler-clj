(ns euler-clojure.core
  (:gen-class))


(defn is-palindrome? [number]
  (def value (atom (str number)))
  (def a (atom (vec (seq @value))))
  (def b (atom (vec (reverse @a))))

  (every? #(true? %) 
    (map = 
         (subvec @a 0 (/ (count @a) 2))
         (subvec @b 0 (/ (count @b) 2)))))

(defn -main
  [& args]
  (println
    (reduce max 0 
      (for [x (range 100 1000) y (range 100 1000) :when 
            (is-palindrome? (* x y))] ( * x y)))))
