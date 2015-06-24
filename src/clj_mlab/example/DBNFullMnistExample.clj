; Linear Discriminant Analysis
(ns clj-mlab.example.DBNFullMnistExample
  (:import [org.deeplearning4j.datasets.iterator DataSetIterator])
  (:import [org.deeplearning4j.datasets.iterator.impl MnistDataSetIterator])
  (:import [org.deeplearning4j.eval Evaluation])
  (:import [org.deeplearning4j.nn.api OptimizationAlgorithm])
  (:import [org.deeplearning4j.nn.conf MultiLayerConfiguration NeuralNetConfiguration NeuralNetConfiguration$Builder])
  (:import [org.deeplearning4j.nn.conf.distribution NormalDistribution])
  (:import [org.deeplearning4j.nn.conf.layers RBM])
  (:import [org.deeplearning4j.nn.conf.override ClassifierOverride])
  (:import [org.deeplearning4j.nn.multilayer MultiLayerNetwork])
  (:import [org.deeplearning4j.nn.weights WeightInit])
  (:import [org.deeplearning4j.optimize.api IterationListener])
  (:import [org.deeplearning4j.optimize.listeners ScoreIterationListener])
  (:import [org.nd4j.linalg.api.buffer DataBuffer])
  (:import [org.nd4j.linalg.api.ndarray INDArray])
  (:import [org.nd4j.linalg.dataset DataSet])
  (:import [org.nd4j.linalg.factory Nd4j])
  (:import [org.nd4j.linalg.lossfunctions LossFunctions LossFunctions$LossFunction])
  (:import [org.slf4j Logger])
  (:import [org.slf4j LoggerFactory])
  (:import [org.slf4j LoggerFactory])
  (:import [java.util Arrays Collections]))

(def numRows  (int 28))
(def numColumns (int 28))
(def outputNum  (int 10))
(def numSamples (int 60000))
(def batchSize (int 100))
(def iterations (int 10))
(def seed (int 123))
(def listenerFreq (int (/ batchSize  5)))

(def iter
  (MnistDataSetIterator. batchSize numSamples))

(def builder
  (doto (NeuralNetConfiguration$Builder.)
    (.layer (RBM.))
    (.nIn (* numRows numColumns))
    (.nOut outputNum)
    (.weightInit WeightInit/DISTRIBUTION)
    (.dist (NormalDistribution. 0 1))
    (.constrainGradientToUnitNorm true)
    (.iterations iterations)
    (.lossFunction LossFunctions$LossFunction/RMSE_XENT)
    (.learningRate 1e-1)
    (.momentum 0.5)
    (.momentumAfter (Collections/singletonMap 3 0.9))
    (.optimizationAlgo OptimizationAlgorithm/LBFGS)))

(def listbuilder
  (doto (.list builder 4)
    (.hiddenLayerSizes (int-array [500 250 200]))
    (.override (ClassifierOverride. 3))))

(def conf
  (.build listbuilder))


(def model
  (doto (MultiLayerNetwork. conf)
    (.init)
    (.setListeners (Collections/singletonList (ScoreIterationListener. listenerFreq)))
    (.fit iter)))


(defn start []
  (println (class conf))
  (println (class model)))

