import requests
from geopy.geocoders import Nominatim
import json

AIR_QUALITY_API_KEY = "4d8aa992-f3dd-4306-8219-880f0373ed3b"

geolocator = Nominatim(user_agent="final_project")

print('Welcome to Weather or Not. Please input a location to check data for. (Zip code, address or city)')
user_loc = input('> ')

location = geolocator.geocode(user_loc)

r = requests.get(f"https://api.weather.gov/points/{location.latitude},{location.longitude}")
data = r.json()

forecast = requests.get(data['properties']['forecast'])

# print(json.dumps(forecast.json(), indent=2))

air_quality = requests.get(f'http://api.airvisual.com/v2/nearest_city?lat={location.latitude:.3f}&lon={location.longitude:.3f}&key={AIR_QUALITY_API_KEY}')
print(json.dumps(air_quality.json(), indent=2))

