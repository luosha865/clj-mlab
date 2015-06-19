; Linear Discriminant Analysis
(ns clj-mlab.classifiers.lda
  (:require [incanter.core :refer :all]
            [incanter.stats :refer :all]
            [incanter.charts :refer :all]
            [incanter.datasets :refer :all]
            [incanter.io :refer :all]))

(def training
  (to-matrix
    (read-dataset "data/vowel.train" :header true)))
(def testing
  (to-matrix
    (read-dataset "data/vowel.test" :header true)))

(def K 11)

(def p 10)

(def N (nrow training))

(def group-counts
  (map nrow
    (group-on training 1)))

(def prior-probs
  (div group-counts N))

(def cluster-centroids
  (matrix
    (for [x_k (group-on training 1 :cols (range 2 12))]
      (map mean (trans x_k)))))

(def cluster-cov-mat
  (let [groups (group-on training 1 :cols (range 2 12))]
    (reduce plus
      (map (fn [group centroid n]
             (reduce plus
               (map #(div
                       (mmult (trans (minus % centroid))
                         (minus % centroid))
                       (- N K))
                 group)))
        groups cluster-centroids group-counts))))

(def inv-cluster-cov-mat (solve cluster-cov-mat))

(defn ldf [x Sigma-inv mu_k pi_k]
  (+ (first (mmult x Sigma-inv (trans mu_k)))
    (- (first (mult 1/2 (mmult mu_k Sigma-inv (trans mu_k)))))
    (log pi_k)))

(defn calculate-scores
  ([data inv-cov-mat centroids priors]
    (matrix
      (pmap (fn [row]
              (pmap (partial ldf row inv-cov-mat)
                centroids
                priors))
        (sel data :cols (range 2 12))))))

(def training-lda-scores
  (calculate-scores training
    inv-cluster-cov-mat
    cluster-centroids
    prior-probs))

(defn max-index
  ([x]
    (let [max-x (reduce max x)
          n (length x)]
      (loop [i 0]
        (if (= (nth x i) max-x)
          i
          (recur (inc i)))))))

(map max-index training-lda-scores)

(defn error-rate [data scores]
  (/ (sum (map #(if (= %1 %2) 0 1)
            (sel data :cols 1)
            (plus 1 (map max-index scores))))
    (nrow data)))

(def testing-lda-scores
  (calculate-scores testing
    inv-cluster-cov-mat
    cluster-centroids
    prior-probs))

(defn start
  []
  (println (error-rate training training-lda-scores))
  (println (error-rate testing testing-lda-scores)))
