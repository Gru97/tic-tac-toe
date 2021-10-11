(ns tic-tac-toe.core-test
  (:require [clojure.test :refer :all]
            [tic-tac-toe.core :refer :all]))

(def tripple '((1 2 3) (4 5 6) (7 8 9) (1 4 7) (2 5 8) (3 6 9) (1 5 9) (3 5 7)))

(deftest create-tripples
  (testing "tripples must be created"
    (is (= tripple (tripples [1 2 3 4 5 6 7 8 9])))))


