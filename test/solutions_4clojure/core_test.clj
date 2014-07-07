(ns solutions-4clojure.core-test
  (:require [clojure.test :refer :all]
            [solutions-4clojure.easy :refer :all]
            [solutions-4clojure.elementary :refer :all]))

(deftest test-134
  (testing "map with nil for value"
    (is (= (sol-134 {1 :a 2 :b 3 nil} 3)))))

(deftest test-156
  (testing "Creating a map with defaults"
    (is (= (sol-156 "foo" [:a :b :c])
           {:a "foo" :b "foo" :c "foo"}))))

(deftest test-my-count
  (testing "Re-implementation of count"
    (is (= (my-count [1 2 3 4]) 4))
    (is (= (my-count []) 0))
    (is (= (my-count {:a 1 :b 2} ) 2))))

(deftest test-my-reverse
  (testing "Reversing a seq"
    (is (= (my-reverse [1 2 3]) [3 2 1]))
    (is (= (= (my-reverse []) [])))))

(deftest test-my-interleave
  (testing "my-interleave problem 39"
    (is (= (sol-39 [1 2] [3 4 5 6]) '(1 3 2 4)))))
  
(deftest test-my-compress
  (testing "problem 30 - my-compress"
    (is (= (sol-30 [1 1 2 2 3 3 3 1]) [1 2 3 1]))))

(deftest test-40
  (testing "problem 40 - interpose"
    (is (= (sol-40 1 [2 3 4 5]) [2 1 3 1 4 1 5]))))

(deftest test-41
  (testing "problem 41 - drop-nth"
    (is (= (sol-41 [:a :b :c :d :e :f] 2) [:a :c :e]))
    (is (= (sol-41 [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8]))))
