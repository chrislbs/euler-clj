(ns euler-clojure.problem8
  (:require [clojure.string :as clj-str]))

(def big-number
  (clj-str/join
    ""
    [
      "73167176531330624919225119674426574742355349194934"
      "96983520312774506326239578318016984801869478851843"
      "85861560789112949495459501737958331952853208805511"
      "12540698747158523863050715693290963295227443043557"
      "66896648950445244523161731856403098711121722383113"
      "62229893423380308135336276614282806444486645238749"
      "30358907296290491560440772390713810515859307960866"
      "70172427121883998797908792274921901699720888093776"
      "65727333001053367881220235421809751254540594752243"
      "52584907711670556013604839586446706324415722155397"
      "53697817977846174064955149290862569321978468622482"
      "83972241375657056057490261407972968652414535100474"
      "82166370484403199890008895243450658541227588666881"
      "16427171479924442928230863465674813919123162824586"
      "17866458359124566529476545682848912883142607690042"
      "24219022671055626321111109370544217506941658960408"
      "07198403850962455444362981230987879927244284909188"
      "84580156166097919133875499200524063689912560717606"
      "05886116467109405077541002256983155200055935729725"
      "71636269561882670428252483600823257530420752963450"
      ]
    ))

(defn to-int [char]
  (- (int char) 48))

(defn run []
  (reduce
    (fn [prev cur]
      (let [ highest-prod (get prev 0)
             prev-prod (get prev 1)
             prev-nums (get prev 2)
             cur-num (to-int cur) ]
        (cond
          (= 0 cur-num) [highest-prod 0 [] ]
          (< (count prev-nums) 4) [highest-prod 0 (conj prev-nums cur-num)]
          (= (count prev-nums) 4)
          (let
              [nums (conj prev-nums cur-num)
               prod (reduce * nums)]
            [(max highest-prod prod) prod nums])
          :else
          (let [nums (conj (subvec prev-nums 1) cur-num)
                prod (* (/ prev-prod (first prev-nums)) cur-num)]
            [(max highest-prod prod) prod nums]))))
    [ 0 0 [] ]
    (seq big-number)))

; This initial simple solution also works, the performance testing in the REPL is very
; inconsistent however vs my "optimized" approach.
; The first run of each tends to show the "optimized" version about twice the speed,
; then this one performs better and better typically on subsequent runs
(defn temp []
  (reduce
    (fn [prev cur]
      (let [highest-prod (get prev 0)
            prev-nums (get prev 1)
            cur-num (to-int cur)]
        (if (< (count prev-nums) 5)
          [highest-prod (conj prev-nums cur-num)]
          [ (max highest-prod (reduce * (conj (rest prev-nums) cur-num)))
            (conj (subvec prev-nums 1) cur-num)]
          )))
    [0 [] ]
    (seq big-number)))
