# Web Scrapping App

## Application

This application takes any amazon prduct url and [web scrapes](https://en.wikipedia.org/wiki/Web_scraping) the page to get relevent information **like** :

- Product Name/Title
- Product image url
- Product description
- Product price
- Product total number of reviews.

The product details are saved in [mongo-db](https://www.mongodb.com/) using spring-boot as a framework.

The Application has 2 parts:

#### 1.Web scraping
  
  Scraps the url given in the api as the parameter and extracts the the requried details. Then calling the repository to save the product details.
  
#### 2.Respository

  Stores the value in the mongo repository and returns the stored value.


---------------

### Installation

clone the project in your local system using

```
git clone https://github.com/darkSoulDeveloper/WebScrapping.git
```

once cloned enter the folder `WebScrapping` and build the docker images using

```
sudo docker-compose build 
```
_The build will take some to complete_

Once completed run the docker-compose using

```
sudo docker-compose up -d
```

test if all the container's are up and running use 

```
sudo docker ps
```

----------

### Run

To run the code , call the api

```
curl --location --request POST 'http://127.0.0.1:8362/scrapper/fetch/url?url={amazonProductUrl}' --header 'Content-Type: application/json'
```
the api takes only one parameter `url` which can any amazon product url.

#### Example:

**API**

```
curl --location --request POST 'http://127.0.0.1:8362/scrapper/fetch/url?url=https://www.amazon.com/Wireless-Gaming-Microphone-Podcasting-Streaming/dp/B095YJBBM8' --header 'Content-Type: application/json'

```


The **Response** for the api is :

```
{
    "url":"https://www.amazon.com/Wireless-Gaming-Microphone-Podcasting-Streaming/dp/B095YJBBM8",
    "product":{
        "name":"UHURU Wireless Gaming Mouse WM-02 with USB RGB Microphone for Podcasting,Gaming and Streaming",
        "imageURL":"https://images-na.ssl-images-amazon.com/images/I/615Ai0XxasS.__AC_SX300_SY300_QL70_ML2_.jpg",
        "description":"This fits your . Make sure this fits by entering your model number. 丨Get Away from the Cable丨ENJOY CLUTTER-FREE GAMING WITHOUT THE CABLE. Wireless gaming mouse for 50ft wireless transmission. The response is near-instantaneous. Response rate represent the data transmission speed between the mouse and computer, a higher rate of response in games competitions can better play the performance of the mouse and allows the mouse to be zero delay and no jump during fierce gaming, which is more realistic for Gaming Players. 丨Control Your Own Speed at Your Will丨5 level DPI by press the button below the scroll wheel. No need any driver, plug and play directly. You can easily adjust the moving speed, perfect for games and office, meet your multiple needs. This mouse provides extreme stability while gaming, such as League of Legends, World of Warcraft, DOTA, CS etc. 丨Two Selectable Pick-up Pattens丨The USB microphone features Cardioid and Omnidirectional polar patterns. Cardioid pattern is sensitive to sound coming from directly in front of the mic, while rejecting sound coming from behind the mic. Omnidirectional Pattern pick up sound from all directions. It allows you to turn the knob to mute. You do not have to turn the microphone off or unplug it every single night. 丨Dynamic RGB Lighting Effects丨The gaming microphone has RGB lights, which is better to create an active and cool atmosphere, allowing you to enter work or game faster. It will keep switching colors when powered. Note: The colors and brightness are set. You can't control the colors or the speed of the transition. 丨Zero-latency Monitoring & Gain Control丨The headphone jack is located in the microphone so you can hear everything that is going on without computer delay or again having to find a plugin in the back of your pc or even laptop. You easily control the volume of the headphone with gain control",
        "price":"$87.99",
        "totalReviews":0
    }
}

```




