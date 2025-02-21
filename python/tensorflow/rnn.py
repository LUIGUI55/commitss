import numpy as np
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import SimpleRNN, Dense

model = Sequential()
model.add(SimpleRNN(50, activation='relu', input_shape=(10, 1)))
model.add(Dense(1))

model.compile(optimizer='adam', loss='mse')

# Datos de ejemplo
X = np.random.rand(100, 10, 1)
y = np.random.rand(100, 1)

model.fit(X, y, epochs=10)