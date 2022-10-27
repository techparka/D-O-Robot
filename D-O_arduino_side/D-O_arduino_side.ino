
#include <Servo.h>

Servo bigServo;
Servo inboxServo;
Servo leftrightServo;
Servo yawServo;

#define ENA_1 6       // Enable/speed motor Front Right 
#define ENB_2 11        // Enable/speed motor Back Right

#define IN_1  12        // motor driver #1 in 1 motor 
#define IN_2  13        // motor driver #1 in 2 motor 

#define sound 2

#define OUT_SERWO_BIG 3
#define OUT_SERWO_PITCH 5
#define OUT_SERWO_LEFTRIGHT 9
#define OUT_SERWO_YAW 10

int yawServoPos=35; 
int inboxServoPos=45;
int leftrightServoPos=38;


//int speedCarTemp = 150;
int pos = 45;
int command;            //Int to store app command state.
int speedCar = 10;     // 50 - 255.
int speed_Coeff = 1;
//boolean lightFront = false;
//boolean horn = false;

void setup() {  
   
    //pinMode(light_FR, OUTPUT);
    //pinMode(light_FL, OUTPUT);
    //pinMode(horn_Buzz, OUTPUT);
    
    pinMode(ENA_1, OUTPUT);
    pinMode(ENB_2, OUTPUT);
 
  
    pinMode(IN_1, OUTPUT);
    pinMode(IN_2, OUTPUT);

    pinMode(sound, OUTPUT);
    
    digitalWrite(sound, HIGH);
    yawServo.write(35); 
    leftrightServo.write(38);
    inboxServo.write(40);  
    bigServo.write(35);
    

    bigServo.attach(OUT_SERWO_BIG);
    inboxServo.attach(OUT_SERWO_PITCH);
    leftrightServo.attach(OUT_SERWO_LEFTRIGHT);
    yawServo.attach(OUT_SERWO_YAW);


  Serial.begin(9600); 

  }
  
  void goSerwoLeftBig(){ 
  //      for (pos = 40; pos <= 45; pos += 1) { // goes from 0 degrees to 180 degrees
//            // in steps of 1 degree
            bigServo.write(40);              // tell servo to go to position in variable 'pos'
//            delay(15); 
//       }
  }

  void goSerwoRightBig(){ 
//        for (pos = 45; pos <= 40; pos -= 1) { // goes from 0 degrees to 180 degrees
//              // in steps of 1 degree
             bigServo.write(30);              // tell servo to go to position in variable 'pos'
//             delay(15); 
//        }
  }
  
  void goSerwoLeftPitch(){ 
        for (pos = 40; pos <= 60; pos += 1) { // goes from 0 degrees to 180 degrees
//            // in steps of 1 degree
            inboxServo.write(pos);              // tell servo to go to position in variable 'pos'
            inboxServoPos=pos;
            delay(10); 
        }
  }

  void goSerwoRightPitch(){ 
        for (pos = 40; pos >= 20; pos -= 1) { // goes from 0 degrees to 180 degrees
//              // in steps of 1 degree
             inboxServo.write(pos);              // tell servo to go to position in variable 'pos'
             inboxServoPos=pos;
             delay(15); 
        }
  }
  
  void goSerwoLeftROLL(){ 
        for (pos = 38; pos <= 70; pos += 1) { // goes from 0 degrees to 180 degrees
            // in steps of 1 degree
            leftrightServo.write(pos);              // tell servo to go to position in variable 'pos'
            leftrightServoPos=pos;
            delay(15); 
        }
  }

  void goSerwoRightROLL(){ 
        for (pos =38; pos >= 10; pos -= 1) { // goes from 0 degrees to 180 degrees
              // in steps of 1 degree
             leftrightServo.write(pos);              // tell servo to go to position in variable 'pos'
             leftrightServoPos=pos;
             delay(15); 
        }
  }

  void goSerwoLeftYAW(){ 
     for (pos =35; pos <= 70; pos += 1) { // goes from 0 degrees to 180 degrees
              // in steps of 1 degree
            yawServo.write(pos);              // tell servo to go to position in variable 'pos'
            yawServoPos=pos;
                delay(15); 
        }
        
  }

  void goSerwoRightYAW(){ 
      for (pos =35; pos >= 0; pos -= 1) { // goes from 0 degrees to 180 degrees
              // in steps of 1 degree
      yawServo.write(pos);              // tell servo to go to position in variable 'pos'
      yawServoPos=pos;
                      delay(15); 
        }
      
  }

  void goSerwoReset(){
//yawServo
    if(yawServoPos>35)
    {
      for(pos=yawServoPos; pos>=35; pos--)
      {
    yawServo.write(pos); 
    delay(15);
      }
    }
    else{
        for(pos=yawServoPos; pos<=35; pos++)
      {
    yawServo.write(pos); 
    delay(15);
      }
    }
    yawServoPos=35;
//leftrightServo
     if(leftrightServoPos>38)
    {
      for(pos=leftrightServoPos; pos>=38; pos--)
      {
    leftrightServo.write(pos);
    delay(15); 
      }
    }
    else{
        for(pos=leftrightServoPos; pos<=38; pos++)
      {
    leftrightServo.write(pos); 
    delay(15);
      }
    }
    leftrightServoPos=38;
 //  inboxServo
     if(inboxServoPos>40)
    {
      for(pos=inboxServoPos; pos>=40; pos--)
      {
    inboxServo.write(pos); 
    delay(15);
      }
    }
    else{
        for(pos=inboxServoPos; pos<=40; pos++)
      {
    inboxServo.write(pos); 
    delay(15);
      }
    }
    inboxServoPos=40;

 //
    //  yawServo.write(35); 
   // leftrightServo.write(38);
   // inboxServo.write(40);  
    bigServo.write(35);
    
    }

   void goSound(){ 
      digitalWrite(sound, LOW);              // make sound
      delay(100);
      digitalWrite(sound, HIGH);
  }

//------------------------------------------------------------------------

void goAhead(){ 
      
    for (speedCar ; speedCar <= 255 ; speedCar++ ){
      digitalWrite(IN_1, HIGH);
      analogWrite(ENA_1, speedCar);

      digitalWrite(IN_2, HIGH);
      analogWrite(ENB_2, speedCar);
      delay(2);
      }
}

void goBack(){ 

    for (speedCar ; speedCar <= 255 ; speedCar++ ){
      digitalWrite(IN_1, LOW);
      analogWrite(ENA_1, speedCar);

      digitalWrite(IN_2, LOW);
      analogWrite(ENB_2, speedCar);
      delay(2);
      }
}

void goRight(){ 

    for (speedCar ; speedCar <= 255 ; speedCar++ ){
      digitalWrite(IN_1, LOW);
      analogWrite(ENA_1, speedCar);

      digitalWrite(IN_2, HIGH);
      analogWrite(ENB_2, speedCar);
    }

  }
  
void goLeft(){

    for (speedCar ; speedCar <= 255 ; speedCar++ ){
      digitalWrite(IN_1, HIGH);
      analogWrite(ENA_1, speedCar);

      digitalWrite(IN_2, LOW);
      analogWrite(ENB_2, speedCar);
    }

        
  }

void goAheadRight(){

     for (speedCar ; speedCar <= 255 ; speedCar++ ){
      digitalWrite(IN_1, HIGH);
      analogWrite(ENA_1, speedCar);

      digitalWrite(IN_2, HIGH);
      analogWrite(ENB_2, speedCar/speed_Coeff);
      delay(2);
     }
  }

void goAheadLeft(){
      
     for (speedCar ; speedCar <= 255 ; speedCar++ ){ 
      digitalWrite(IN_1, HIGH);
      analogWrite(ENA_1, speedCar/speed_Coeff);

      digitalWrite(IN_2, HIGH);
      analogWrite(ENB_2, speedCar);
      delay(2);
     }
  }

void goBackRight(){ 

    for (speedCar ; speedCar <= 255 ; speedCar++ ){
      digitalWrite(IN_1, LOW);
      analogWrite(ENA_1, speedCar/speed_Coeff);

      digitalWrite(IN_2, LOW);
      analogWrite(ENB_2, speedCar);
      delay(2);
    }
  }

void goBackLeft(){ 

    for (speedCar ; speedCar <= 255 ; speedCar++ ){
      digitalWrite(IN_1, LOW);
      analogWrite(ENA_1, speedCar);

      digitalWrite(IN_2, LOW);
      analogWrite(ENB_2, speedCar/speed_Coeff);
      delay(2);
    }
  }

void stopRobot(){  

    for (speedCar; speedCar >= 0; speedCar--){
      //digitalWrite(IN_1, LOW);
      analogWrite(ENA_1, speedCar);

     // digitalWrite(IN_2, LOW);
      analogWrite(ENB_2, speedCar);
      delay(2);
      
    }
    if (speedCar == 0){
      digitalWrite(IN_1, LOW);
      digitalWrite(IN_2, LOW);
      analogWrite(ENB_2, 0);
      analogWrite(ENA_1, 0);
    }
  }
  
void loop(){
    
if (Serial.available() > 0) {
  command = Serial.read();
  
//if (lightFront) {digitalWrite(light_FR, HIGH); digitalWrite(light_FL, HIGH);}
//if (!lightFront) {digitalWrite(light_FR, LOW); digitalWrite(light_FL, LOW);}
//if (horn) {digitalWrite(horn_Buzz, HIGH);}
//if (!horn) {digitalWrite(horn_Buzz, LOW);}

switch (command) {
case 'F':goAhead();break;
case 'B':goBack();break;
case 'L':goLeft();break;
case 'R':goRight();break;
case 'I':goAheadRight();break;
case 'G':goAheadLeft();break;
case 'J':goBackRight();break;
case 'H':goBackLeft();break;
case '0':speedCar = 100;break;
case '1':speedCar = 120;break;
case '2':speedCar = 135;break;
case '3':speedCar = 155;break;
case '4':speedCar = 170;break;
case '5':speedCar = 185;break;
case '6':speedCar = 195;break;
case '7':speedCar = 215;break;
case '8':speedCar = 235;break;
case '9':speedCar = 255;break;
case 'S':stopRobot();goSerwoReset();break;
case 'C':goSerwoLeftBig();break;
case 'D':goSerwoRightBig();break;
case 'E':goSerwoLeftPitch();break;
case 'M':goSerwoRightPitch();break;
case 'N':goSerwoLeftROLL();break;
case 'O':goSerwoRightROLL();break;
case 'T':goSerwoLeftYAW();break;
case 'U':goSerwoRightYAW();break;
case 'W':goSound();break;

}
}
}
