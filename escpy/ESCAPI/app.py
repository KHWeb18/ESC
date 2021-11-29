import flask
from flask import requests

app = flask.Flask(__name__)

@app.route('/', methods=['GET'])
def home():
    arg = requests.args['arg1']
    return 'Hello world'