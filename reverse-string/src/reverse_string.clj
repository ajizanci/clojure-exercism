(ns reverse-string)

(defn reverse-string [s]
  (let [n (count s) 
        indices (range n)]
    (->> indices
        (map #(nth s (- n % 1)))
         (apply str)))
)
