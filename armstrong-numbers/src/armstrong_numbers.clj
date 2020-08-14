(ns armstrong-numbers)

(defn- expt [a b]
  (loop [prod 1 b b]
    (if (> b 0)
      (recur (* prod a) (- b 1))
      prod)))

(defn armstrong? [num] ;; <- arglist goes here
  (let [s (seq (str num))
        n (count s)
        digits (map #(Integer/parseInt (str %)) s)]
    (= (->> digits
            (map #(expt % n))
            (apply +))
       num)))
