from twilio.rest import TwilioRestClient


class Human:
    # last known gps location
    location = (0, 0)
    # heart exhibited anomalous behavior in current session
    healthy = True
    # contacts
    numbers = None
    # my name
    name = None
    # last know heart rate
    heartrate = None

    # info for twilio
    sid = None
    token = None
    # my num
    number = None

    def __init__(self, _name=None, _numbers=[]):
        self.numbers = _numbers
        self.sid = "AC29db2abe1bfa5bba4b73128ca1376347"
        self.token = "b838af10c816cd3d6c82cdab677af331"
        self.number = "+16073912565"
        self.name = _name
        self.heartrate = 1

    def update_heartrate(self, _heartrate):
        self.heartrate = _heartrate

    def get_heartrate(self):
        return self.heartrate

    def update_location(self, _location=()):
        self.location = _location

    def update_health(self, _healthy=True):
        self.healthy = _healthy

    def update_numbers(self, _numbers=[]):
        # add new numbers without introducing duplicates
        self.numbers = list(set(self.numbers + _numbers))

    def call_contacts(self, sid=None, token=None):
        client = TwilioRestClient(sid, token)
        for recipient in self.numbers:
            client.messages.create(to=recipient, from_=self.number, body=("your friend is having %s is having a "
                                                                         "heart attack" % self.name))