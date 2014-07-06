(ns solutions-4clojure.easy)

(defn my-count 
" #22
Function to count length of a sequence
NOTE: using a name without needing a def, cool!
"
  [s]
  (if (empty? s) 0 (+ 1 (my-count (rest s)))))

(defn my-reverse
  "#23 - reverse a sequence"
  [a-seq]
  (if (empty? a-seq) nil (concat (my-reverse (rest a-seq)) (list (first a-seq)))))

; what I meant =)
(partial
  (fn [rs is]
    (if (empty? is)
      rs
      (recur (conj rs (first is)) (rest is)))) ())

; #25
; find the odd numbers

(defn s25 [a-seq]
  (filter #(odd? %) a-seq))

(assert (= (s25 #{1 2 3 4 5}) '(1 3 5)))

; #26
; yay, fibonacci numbers! (starting with 1)

(fn [n]
  (take
    n
    ((fn rfib [a b]
       (cons a (lazy-seq (rfib b (+ a b))))) 1 2)))

; #27
; Palindrome detector!

(defn s27 [a-string]
  (let [len (count a-string)]
    (cond
      (or
        (= 0 len)
        (= 1 len))
      true
      :else (and
              (= (first a-string) (last a-string))
              (s27 (take (- len 2) (rest a-string)))))))


; #28
; implement 'flatten'
(defn my-flatten [coll]
  (if (sequential? coll)
    (mapcat my-flatten coll)
    (list coll)))

; #29
; return only CAPS
(defn s29 [s]
  (apply str (filter #(and (<= (int %) 90) (>= (int %) 65)) s)))

; oh this is a good one:
(fn [s] (reduce str (re-seq #"[A-Z]" s)))

; #30
; remove consecutive duplicates from a sequence
(fn s30 [a-seq]
  (reverse (reduce (fn [acc elt]
                     (if (= (first acc) elt) acc (conj acc elt))) '() a-seq)))

; #31
; pack consequtive duplicates into sublists

(fn [s] (partition-by identity))

; #32
; duplicate each element in a sequence
(fn ! [s]
  (if (empty? s) '() (cons (first s) (cons (first s) (! (rest s))))))

; #33
; replicate each element of a sequence given # of times

(fn [s n]
  (mapcat (partial repeat n) s))

; #34
; implement range
(fn ! [b e] (if (= b e) (list) (cons b (! (inc b) e))))

; #38
; implement max with variable params
(fn [& args]
  (reduce (fn [a b] (if (< a b) b a)) args))

; #39
; implement interleave
(fn ! [a-seq b-seq]
  (if (or (empty? a-seq) (empty? b-seq))
    '()
    (cons (first a-seq) (cons (first b-seq) (! (rest a-seq) (rest b-seq))))))

; lol! --> #(mapcat list %1 %2)

; #40
; implement interpose
(fn [a-sym a-seq]
  (rest (mapcat #(list a-sym %) a-seq)))

; #41
; implement drop-nth
(defn s41 [a-seq n]
  (let [helper
        (fn helper [a-seq m]
          (if (empty? a-seq)
            (list)
            (if (= m n)
              (helper (rest a-seq) 1)
              (cons (first a-seq) (helper (rest a-seq) (inc m))))))]
    (helper a-seq 1)))

;and then there's this:
#(apply concat (partition-all (dec %2) %2 %))


; #42
; yay, factorial
#(reduce * (range 1 (inc %)))

(defn sol-39
  "Write a function which takes two sequences and returns the first item from each, then the second item from each, then the third, etc...lol, (mapcat list)"
  [a-seq b-seq]
  (let [helper
        (fn helper [a-seq b-seq acc]
;          (println "a-seq:" a-seq ", b-seq:" b-seq ", acc: " acc)
          (if (or (empty? a-seq) (empty? b-seq)) acc
              (helper (rest a-seq)
                      (rest b-seq)
                      (into acc (list (first a-seq)
                                      (first b-seq))))))]
    (helper a-seq b-seq [])))

(defn sol-30
  "Write a function which removes consecutive duplicates from a sequence.
   good one: #(map first (partition-by identity %))"
  [a-seq]
  (let
      [helper
       (fn helper [acc elt]
;         (println "acc=" acc ",seq=" a-seq)
         (cond
          (empty? a-seq) acc
          (= (last acc) elt) acc
          :else (conj acc elt)))]
;    (println "input is:" a-seq)
    (reduce helper [] a-seq)))

(defn sol-40
  "Write a function which separates the items of a sequence by an arbitrary value."
  [a-val a-seq]
  (butlast (mapcat #(list % a-val) a-seq)))
            
