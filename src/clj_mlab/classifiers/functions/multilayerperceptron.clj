(ns clj-mlab.classifiers.functions.multilayerperceptron
  (:import [weka.classifiers.functions MultilayerPerceptron])
  (:require [clj-mlab.core.data :as data]))


(defn create-MultilayerPerceptron []
  (let [cls (MultilayerPerceptron.)]
    cls))

