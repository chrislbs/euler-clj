(ns euler-clojure.problem5
  (:require [euler-clojure.math.util :as math-util]))

(defn run [] (math-util/lcm (range 2 21)))
