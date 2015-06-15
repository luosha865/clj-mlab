(ns clj-weka.clusterers.simplekmeans
  (:import [weka.clusterers SimpleKMeans])
  (:require [clj-weka.core.data :as data]))


(defn create-SimpleKmeans []
  (let [cls (SimpleKMeans.)]
    cls))

