"""
To run this app, in your terminal:
> python wine_category_api.py
    Good examples to show that its predicting correctly based on food:
        crisp white good with chicken
        crisp white good with fish
"""
import connexion
from joblib import load

# Instantiate our Flask app object
app = connexion.FlaskApp(__name__, port=8080, specification_dir='swagger/')
application = app.app

# Load our pre-trained wine model
clf = load('./model/wine_model.joblib')

# Implement a simple health check function (GET)
def health():
    # Test to make sure our service is actually healthy
    try:
        predict("citrus and crisp")
    except:
        return {"Message": "Service is unhealthy"}, 500

    return {"Message": "Service is OK"}

# Implement our predict function
def predict(wine_description):
    # Accept the feature values provided as part of our POST
    # Use these as input to clf.predict()
    prediction = clf.predict([wine_description])

    # Return the prediction as a json
    return {"prediction" : str(prediction)}

# Read the API definition for our service from the yaml file
app.add_api("wine_category_classification_api.yaml")

# Start the appcd ..
if __name__ == "__main__":
    app.run()
