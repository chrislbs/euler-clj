(ns euler-clojure.problem13
  (:require [clojure.java.io :as clj-io])
  (:require [clojure.string :as clj-str]))

(def resource-name "problem13.txt")

(def the-numbers
  (map
    #(new java.math.BigInteger %)
    (clj-str/split-lines
      (slurp (clj-io/resource resource-name)))))

(defn run []
  (apply str (take 10 (seq (str (reduce + the-numbers))))))
