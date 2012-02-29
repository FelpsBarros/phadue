#include <SPI.h>
#include <Ethernet.h>

byte mac[] = {0xDE, 0xAD, 0xBE, 0xBE, 0xFE, 0xEd};
IPAddress ip(192, 168, 0, 99);

EthernetServer server(1802);

void setup() {
  
  Serial.begin(9600);

  Ethernet.begin(mac, ip);    
  server.begin();
  
  pinMode(7, OUTPUT);
}

void loop() {
  
  EthernetClient client = server.available();
  
  if (client) {
    
    if (client.connected()) {
      
      char c = client.read();
      
      if (c == '1') {
        digitalWrite(7, 1);
        client.println("OK - LED turned on");
      } else if (c == '0') {
        digitalWrite(7, 0);
        client.println("OK - LED turned off");
      } else {
        client.println("ERROR - Unknowm message");
      }
      
    }
   
    delay(10);
    client.stop();
  }
}
