from flask import Flask, request
from hearts_out import Predict
from human import Human


app = Flask(__name__)


@app.route('/data')
def parse_dat():

    # check if entry contains phone numbers
    numbers = request.args.get("numbers")
    if numbers is not None:
        jeb.update_numbers(numbers)

    # check if entry contains gps data
    gps = request.args.get("gps")
    if gps is not None:
        jeb.update_location(gps)

    # check if entry contains heart rate data
    data = request.args.get("data")
    if data is not None:
        data = data.split(',')

        if len(data) > 5:
            in_5 = map(float, iter(data[-6:-1]))

            actual = float(data[:(len(data)-1)][0])

            print(in_5)
            print(actual)
            jeb.update_heartrate(actual)

            if abs(float(pre.predict_new(in_5))-actual) < .3*actual:
                # heart attack condition
                jeb.call_contacts()

    return "request received"


@app.route('/bpm')
def index():
    return str(60000/(jeb.get_heartrate()))

jeb = Human(_numbers="+16073398907")


pre = Predict()
pre.train_model()

