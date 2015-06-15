(ns clj-weka.classifiers.functions.multilayerperceptron
  (:import [weka.classifiers.functions MultilayerPerceptron])
  (:require [clj-weka.core.data :as data]))


(defn create-MultilayerPerceptron []
  (let [cls (MultilayerPerceptron.)]
    cls))

