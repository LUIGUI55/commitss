from tensorflow.keras.layers import Input, Dense, LeakyReLU
from tensorflow.keras.models import Model, Sequential

# Generador
generator = Sequential()
generator.add(Dense(256, input_dim=100))
generator.add(LeakyReLU(alpha=0.2))
generator.add(Dense(512))
generator.add(LeakyReLU(alpha=0.2))
generator.add(Dense(1024))
generator.add(LeakyReLU(alpha=0.2))
generator.add(Dense(784, activation='tanh'))

# Discriminador
discriminator = Sequential()
discriminator.add(Dense(1024, input_dim=784))
discriminator.add(LeakyReLU(alpha=0.2))
discriminator.add(Dense(512))
discriminator.add(LeakyReLU(alpha=0.2))
discriminator.add(Dense(256))
discriminator.add(LeakyReLU(alpha=0.2))
discriminator.add(Dense(1, activation='sigmoid'))

discriminator.compile(optimizer='adam', loss='binary_crossentropy')

