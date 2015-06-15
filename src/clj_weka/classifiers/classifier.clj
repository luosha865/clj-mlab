(ns clj-weka.classifiers.classifier
  (:import [weka.classifiers Evaluation Classifier]
           [weka.core Instances Attribute]
           [java.util Random Date]
           [java.lang Math]
           [java.io ObjectOutputStream FileOutputStream ObjectInputStream FileInputStream])
  (:require [clj-weka.core.data :as data]))




(defn buildClassifier [classifier,dataset]
  (.buildClassifier classifier dataset))

(defn classifyInstance [classifier,instance]
  (.classifyInstance classifier instance))

(defn classifyDateSet [classifier,dataset]
  (let [num (data/num-dataset dataset)]
    (if (> num 0)
      (loop [n 0
             err 0]
        (let [instance (data/instance-at dataset n)
              cls (classifyInstance classifier instance)
              e (Math/abs (- (data/class-value instance) cls))]
          (if (< n (- num 1))
            (recur (inc n)  (+ e err) )
            err))))))

