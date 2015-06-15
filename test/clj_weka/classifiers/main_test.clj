(ns clj-weka.classifiers.main-test
  (:require [clj-weka.core.data :as data]
            [clj-weka.classifiers.tree.id3 :as id3]
            [clj-weka.classifiers.tree.simplecart :as simplecart]
            [clj-weka.classifiers.functions.multilayerperceptron :as multilayerperceptron]
            [clj-weka.classifiers.classifier :as classifier]
            [clojure.test :refer :all]))

(deftest a-test
  (let [dataset (data/new-dataset "data/iris.arff")
        numattrs (data/num-attribute dataset)
        cls (simplecart/create-SimpleCart)]
    (do
      (data/set-class-index dataset (- numattrs 1))
      ;(println (data/class-index dataset))
      (classifier/buildClassifier cls dataset)
      (println (classifier/classifyDateSet cls dataset))
      (testing "FIXME, I fail."
        (= 1 1)
        ))))


(deftest b-test
  (let [dataset (data/new-dataset "data/iris.arff")
        numattrs (data/num-attribute dataset)
        cls (multilayerperceptron/create-MultilayerPerceptron)]
    (do
      (data/set-class-index dataset (- numattrs 1))
      ;(println (data/class-index dataset))
      (classifier/buildClassifier cls dataset)
      (println (classifier/classifyDateSet cls dataset))
      (testing "FIXME, I fail."
        (= 1 1)
        ))))