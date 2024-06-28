import pandas as pd
from sklearn.tree import DecisionTreeClassifier

music_data = pd.read_csv('music.csv')
X = music_data.drop(columns = ['genre'])
y = music_data['genre']
model = DecisionTreeClassifier()
model.fit(X, y)
prediction = model.predict([[21,1]])
prediction
# import pandas as pd
# from sklearn.tree import DecisionTreeClassifier
# from sklearn.preprocessing import OneHotEncoder
# from sklearn.compose import ColumnTransformer

# # Load the dataset
# music_data = pd.read_csv('music.csv')

# # Split features and target
# X = music_data.drop(columns=['genre'])
# y = music_data['genre']

# # Preprocess categorical features using one-hot encoding
# # Assuming 'age' and 'gender' are categorical features
# column_transformer = ColumnTransformer(
#     [('encoder', OneHotEncoder(), [0, 1])], 
#     remainder='passthrough')

# X_encoded = column_transformer.fit_transform(X)

# # Initialize and train the model
# model = DecisionTreeClassifier()
# model.fit(X_encoded, y)

# # Make predictions
# prediction = model.predict([[21, 1]])  # Example prediction

# print("Predicted genre:", prediction)

