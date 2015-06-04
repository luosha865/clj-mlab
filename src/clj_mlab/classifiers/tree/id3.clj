(ns clj-mlab.classifiers.tree.id3
  (:import [weka.classifiers.trees Id3])
  (:require [clj-mlab.core.data :as data]))


(defn create-Id3 []
  (let [cls (Id3.)]
    cls))

