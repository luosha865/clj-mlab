(ns clj-weka.clusterers.clusterer
  (:import [weka.clusterers AbstractClusterer NumberOfClustersRequestable]
           [weka.core Instances Attribute]
           [java.util Random Date]
           [java.lang Math]
           [java.io ObjectOutputStream FileOutputStream ObjectInputStream FileInputStream])
  (:require [clj-weka.core.data :as data]))


(defn setNumClusters [clusterer,num]
  (.setNumClusters clusterer num))


(defn buildClusterer [clusterer,dataset]
  (.buildClusterer clusterer dataset))

(defn clusterInstance [clusterer,instance]
  (.clusterInstance clusterer instance))

(defn clusterDateSet [classifier,dataset]
  (let [num (data/num-dataset dataset)]
    (if (> num 0)
      (loop [n 0
             err 0]
        (let [instance (data/instance-at dataset n)
              cls (clusterInstance classifier instance)]
          (println cls)
              ;e (Math/abs (- (data/class-value instance) cls))]
          (if (< n (- num 1))
            (recur (inc n)  (+ 0 err) )
            err))))))

