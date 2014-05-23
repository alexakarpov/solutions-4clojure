(ns solutions-4clojure.elementary)

; Elementary #134

; write a function that take a key and a map and returns true iff the map contains
; the key and it's mapped value is nil

(defn sol-134 [mmap kkey]
  (and
    (contains? mmap kkey)
    (nil? (mmap kkey))))

;#156
;Difficulty:  Elementary
;Topics:      seqs
;
;
;When retrieving values from a map, you can specify default
;values in case the key is not found:
;
;(= 2 (:foo {:bar 0, :baz 1} 2))
;
;However, what if you want the map itself to contain the default
;values? Write a function which takes a default value and a sequence
;of keys and constructs a map.

(defn sol-156 [default-val seq-of-keys]
  (reduce (fn [acc key] (conj acc [key default-val])) {} seq-of-keys))

(assert (= (sol-156 "x" [1 2 3]) {1 "x" 2 "x" 3 "x"}))
(assert (= (sol-156 "x" [:a :b :c]) {:a "x" :b "x" :c "x"}))
; 
; (clojure.set/superset? #{2} #{3})