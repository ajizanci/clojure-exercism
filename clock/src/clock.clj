(ns clock)

(defn clock->string [clock] ;; <- arglist goes here
  (let [hours (:hours clock)
        minutes (:minutes clock)]
    (str
     (when (< hours 10) "0") hours
     ":"
     (when (< minutes 10) "0") minutes)))

(defn- resolve-time [hours minutes]
  [(-> hours
       (+ (int (Math/floor (/ minutes 60))))
       (mod 24))
   (mod minutes 60)])

(defn clock [hours minutes] ;; <- arglist goes here
  (let [[hours minutes] (resolve-time hours minutes)]
    {:hours hours
     :minutes minutes}))

(defn add-time [clockk time] ;; <- arglist goes here
  (clock
   (:hours clockk)
   (+ (:minutes clockk) time)))

(comment
  (mod -1 24)
  (:hours (clock -121 -5810))
  (:minutes (add-time (clock 10 3) -30))
  (clock->string (clock 10 3)))