(ns clj-mlab.classifiers.tree.simplecart
  (:import [weka.classifiers.trees SimpleCart])
  (:require [clj-mlab.core.data :as data]))


(defn create-SimpleCart []
  (let [cls (SimpleCart.)]
    cls))

