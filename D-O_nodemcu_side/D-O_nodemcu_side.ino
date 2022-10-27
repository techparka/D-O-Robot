#include <ESP8266WiFi.h>
#include <WiFiClient.h> 
#include <ESP8266WebServer.h>

#define play 6 //play music
const char* host = "D-O Robot";
const char* ssid = "thelastjedi";

IPAddress ip(192, 168, 4, 1);
IPAddress netmask(255, 255, 255, 0);
const int port = 8080; // Port
ESP8266WebServer server(port);


void setup() {
  Serial.begin(9600);
  pinMode(play, OUTPUT);

// Connecting WiFi

  WiFi.mode(WIFI_AP);
  WiFi.softAP(ssid);
// Starting WEB-server
    
     server.on ("/move", HTTP_GET, HTTP_handleRoot );
     server.onNotFound ( HTTP_handleRoot );
     server.begin();    
     
}

void loop() {
  server.handleClient();
    digitalWrite(play, HIGH);
   delay(50);
}
 
void HTTP_handleRoot(void) {

if( server.hasArg("dir") ){
       Serial.println(server.arg("dir"));
  }
  server.send ( 200, "text/html", "" );
}
