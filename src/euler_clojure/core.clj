(ns euler-clojure.core
  (:gen-class))


(defn -main
  [& args]
  (for
      [ problem-number args
        :when (number? problem-number)]
    (let [ problem-str (format "euler-clojure.problem%d" problem-number)
           problem-ns (symbol problem-str)
           problem-fn (symbol (format "%s/run" problem-str))]
      (require problem-ns)
      (println (format "Running problem %d :" problem-number))
      ((resolve problem-fn))
      )))
