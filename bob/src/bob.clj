(ns bob
  (:require [clojure.string :as string]))

(defn- includes-alphabet? [s]
  (re-find #"[a-zA-Z]" s))

(defn response-for [s] ;; <- arglist goes here
  (let [s (string/trim s)]
    (cond
      (string/blank? s) "Fine. Be that way!"
      (and (= (string/upper-case s) s)
           (includes-alphabet? s)) (if (string/ends-with? s "?")
                                     "Calm down, I know what I'm doing!"
                                     "Whoa, chill out!")
      (string/ends-with? s "?") "Sure."
      :else "Whatever.")))

(comment
  (response-for "\n")
  (response-for "Wait! Hang on. Are you going to be OK?")
  (response-for "It's OK if you don't want to go to the DMV.")
  (response-for "1, 2, 3")
  (response-for "Okay if like my  spacebar  quite a bit?   "))
