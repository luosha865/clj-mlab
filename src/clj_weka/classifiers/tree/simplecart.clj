(ns clj-weka.classifiers.tree.simplecart
  (:import [weka.classifiers.trees SimpleCart])
  (:require [clj-weka.core.data :as data]))


(defn create-SimpleCart []
  (let [cls (SimpleCart.)]
    cls))

