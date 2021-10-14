(ns tic-tac-toe.core-test
  (:require [clojure.test :refer :all]
            [tic-tac-toe.core :refer :all]))

(def tripple '((1 2 3) (4 5 6) (7 8 9) (1 4 7) (2 5 8) (3 6 9) (1 5 9) (3 5 7)))

(deftest create-tripples-test
  (testing "tripples must be created"
    (is (= tripple (tripples [1 2 3 4 5 6 7 8 9])))))

(deftest full-board-test
  (testing "should return true if board is full"
    (is (= true (full-board [:x :o :x :o :x])))
    (is (= false (full-board [1 2 :x 4])))))


(deftest tripple-winner-test
  (testing "should return winner if one player is won"
    (is (= :x (tripple-winner  [:x :x :x ])))
    (is (= nil (tripple-winner  [:x 1 :x])))
    (is (= :o (tripple-winner  [:o :o :o])))))

(deftest who-won-test
  (testing "should return winner of the board"
    (is (= :x (who-won  [:x :x :x 4 5 6 7 8 9])))
    (is (= :o (who-won  [1 :o 3 4 :o 6 7 :o 9])))
    (is (= nil (who-won  [1 2 :o 4 :o 6 7 :o 9])))))


(deftest get-move-from-player-test
  (testing "should accept a number"
    (is (= 1 (get-move-from-player [1 2 3 4 5 6 7 8 9])))))

(deftest play-game-test
  (testing "should-start-game"
    (play-game [1 2 3 4] [:x :y :x :y])))
(run-tests)