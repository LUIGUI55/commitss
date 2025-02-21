from tensorflow.keras.layers import Layer
from tensorflow.keras import backend as K

class CustomLayer(Layer):
    def __init__(self, output_dim, **kwargs):
        self.output_dim = output_dim
        super(CustomLayer, self).__init__(**kwargs)

    def build(self, input_shape):
        self.kernel = self.add_weight(name='kernel', shape=(input_shape[1], self.output_dim), initializer='uniform', trainable=True)
        super(CustomLayer, self).build(input_shape)

    def call(self, inputs):
        return K.dot(inputs, self.kernel)

    def compute_output_shape(self, input_shape):
        return (input_shape[0], self.output_dim)

from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense

model = Sequential()
model.add(Dense(64, input_shape=(20,)))
model.add(CustomLayer(10))
model.add(Dense(1, activation='sigmoid'))

model.compile(optimizer='adam', loss='binary_crossentropy', metrics=['accuracy'])