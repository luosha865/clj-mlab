(ns clj-mlab.clusterers.simplekmeans
  (:import [weka.clusterers SimpleKMeans])
  (:require [clj-mlab.core.data :as data]))


(defn create-SimpleKmeans []
  (let [cls (SimpleKMeans.)]
    cls))

