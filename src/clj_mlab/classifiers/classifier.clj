(ns clj-mlab.classifiers.classifier
  (:import [weka.classifiers Evaluation Classifier]
           [weka.core Instances Attribute]
           [java.util Random Date]
           [java.io ObjectOutputStream FileOutputStream ObjectInputStream FileInputStream])
  (:require [clj-mlab.core.data :as data]))




(defn buildClassifier [cls,dataset]
  (.buildClassifier cls dataset))

(defn classifyInstance [cls,instance]
  (.classifyInstance cls instance))

(defn classifyDateSet [cls,dataset]
  map )