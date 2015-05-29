(ns clj-mlab.data
  (:import [weka.core Attribute FastVector Instance Instances])
  (:import [java.io FileReader]))

(defn is-instance? [instances]
  "Checks if the provided object is instances"
  (if (= weka.core.Instances
        (class instances))
    true
    false))

(defn instances-values-at [instances pos]
  "get possible values for Nominal attrs"
  (let [attr (.attribute instances pos)
        values (.enumerateValues attr)]
    (if (not (nil? values))
      (loop [continue (.hasMoreElements values)
             acum {}]
        (if continue
          (let [val (.nextElement values)
                index (.indexOfValue attr val)]
            (recur (.hasMoreElements values)
              (conj acum {(keyword val) index})))
          acum)))))

(defn is-instance? [instance]
  "Checks if the provided object is an instance"
  (if (= weka.core.Instance
        (class instance))
    true
    false))

(defn attribute-name-at [instance pos]
  (let [attr (.attribute instance pos)]
    (.name attr)))

(defn attribute-value-at [instance pos]
  (let [attr (.attribute instance pos)]
    (if (.isNominal attr)
      (let [val (.value instance pos)
            key-vals (instances-values-at instance pos)
            key-val (loop [ks (keys key-vals)]
                      (if (= (get key-vals (first ks))
                            val)
                        (first ks)
                        (recur (rest ks))))]
        key-val)
      (.value instance pos))))


(defn num-instances [instances]
  (.numInstances instances))

(defn new-instances [file]
  (let [input (new FileReader file)
        instances (new Instances input)]
    instances))