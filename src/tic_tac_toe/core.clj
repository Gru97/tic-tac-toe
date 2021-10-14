(ns tic-tac-toe.core)

(def starting-board [1 2 3 4 5 6 7 8 9])

(defn tripples [board]
  (concat (partition-all 3 board)
          (list
           (take-nth 3 board)
           (take-nth 3 (drop 1 board))
           (take-nth 3 (drop 2 board))
           (take-nth 4 board)
           (take-nth 2 (drop-last 2 (drop 2 board))))))

;(tripples board)

(defn full-board [board]
  (every? #{:x :o} board))


(defn tripple-winner [tripple]
  (if (every? #{:x} tripple) :x (if (every? #{:o} tripple) :o nil)))

(defn who-won [board]
  (first (filter #{:x :o} (map tripple-winner (tripples board)))))


(filter #{:x} [:x :x :y])
;; => (:x :x)

; finit number of choise for a tic-tac-toe: 9 sequence
(def game-rounds (cycle #{:o :x}))
(take 9 game-rounds)

(defn get-move-from-player [board]
        (let [input
                (try (. Integer parseInt (read-line))
                  (catch Exception e nil))]
        (if (some #{input} board) input nil)))

(defn change-board [board move player]
  (assoc board (dec move) player))

(change-board [1 2 3 4] 1 9)

(defn display-board [board] (println (partition-all 3 board)))

 (defn take-turn [board rounds]
   (let [player (first rounds)]
     (println (str "player: " (name player)))
     (change-board board (get-move-from-player board) player) ))

(defn play-game [starting-board game-rounds]
  (loop [starting-board starting-board game-rounds game-rounds]
    (println "current board:") (display-board starting-board)
    (let [winner (who-won starting-board)]
     (cond
        winner (print (str (name winner) " won!"))
       (full-board starting-board) (println "game is drawn")
       :else
          (recur (take-turn starting-board game-rounds) (rest game-rounds))))))

(play-game starting-board game-rounds)


