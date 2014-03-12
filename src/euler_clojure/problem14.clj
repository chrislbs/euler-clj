(ns euler-clojure.problem14)

(def collatz-map (atom {}))

(defn collatz-op [num]
  (if (odd? num) (+ 1 (* 3 num)) (quot num 2)))

(defn collatz-sequence [num]
  (if (= num 1)
    (list 1)
    (cons num (lazy-seq (collatz-sequence (collatz-op num))))))

(defn count-collatz
  ([num]
   (count-collatz num 0))
  ([num count]
   (cond
     (= 1 num) 1
     (contains? @collatz-map num) (+ count (get @collatz-map num))
     :else (count-collatz (collatz-op num) (inc count))))
  )

(defn build-collatz-map [n]
  (if-not (get @collatz-map n)
    (swap!
      collatz-map
      (fn [map] (assoc map n (count-collatz n))))))

(defn run []
  (doall (map build-collatz-map (range 1 1000000)))
  (reduce
    (fn [prev cur]
      (if (> (get prev 1) (get cur 1)) prev cur))
    @collatz-map))
