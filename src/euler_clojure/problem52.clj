(ns euler-clojure.problem52)

(defn contain-the-same-digits? [a b]
  (let [a1 (sort (into [] (str a)))
        b1 (sort (into [] (str b)))]
    (= a1 b1)))

(defn is-permuted-multiple? [n]
  (let [m1 [2 3 4 5 6]
        m2 (map #(* n %) m1)
        results (map #(contain-the-same-digits? n %) m2)]
    (every? true? results)))

(defn run[]
  (let [the-number (atom 1)]
    (while (not (is-permuted-multiple? @the-number))
      (swap! the-number #(+ 1 %)))
    @the-number))
