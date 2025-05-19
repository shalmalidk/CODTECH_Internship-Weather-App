# 🌦️ Weather App (Spring Boot + HTML + OpenWeatherMap API)

This is a simple Weather Web Application that fetches real-time weather data using the OpenWeatherMap API and displays it in a clean, user-friendly format.

# 🔧 Tech Stack

- Java 17+
- Spring Boot
- Spring Web
- HTML5, CSS3, JavaScript
- REST API Integration
- OpenWeatherMap API

# How It Works

1. User enters a city name in the input field.
2. JavaScript sends a GET request to:  
   `http://localhost:8082/api/weather/{city}`
3. Spring Boot controller fetches weather data from OpenWeatherMap API.
4. Response is formatted in HTML and displayed dynamically.

# Features
- Live weather data by city name
- Temperature, humidity, pressure, sunrise/sunset, etc.
- Clean, responsive UI
- Error handling for unavailable data

