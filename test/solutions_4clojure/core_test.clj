(ns solutions-4clojure.core-test
  (:require [clojure.test :refer :all]
            [solutions-4clojure.core :refer :all]
            [solutions-4clojure.elementary :refer :all]))

(deftest test-134
  (testing "map with nil for value"
    (is (= (sol-134 {1 :a 2 :b 3 nil} 3)))))

(deftest test-156
  (testing "Creating a map with defaults"
    (is (= (sol-156 "foo" [:a :b :c])
           {:a "foo" :b "foo" :c "foo"}))))
    