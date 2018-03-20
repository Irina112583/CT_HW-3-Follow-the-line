package linefollow;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;


public class strait {
	public static void main(String[] args) {
		PID car = new PID();
		car.run();
	}
}

class PID{
	public void run() {
		EV3LargeRegulatedMotor leftMotor = new EV3LargeRegulatedMotor(MotorPort.B);
		EV3LargeRegulatedMotor rightMotor = new EV3LargeRegulatedMotor(MotorPort.C);
		EV3ColorSensor rightSensor = new EV3ColorSensor(SensorPort.S3);
		EV3ColorSensor leftSensor = new EV3ColorSensor(SensorPort.S1);
		double Kp = 300;
		double Ki = 0.3;
		double Kd = 30;
   
		double integral = 0;
		double lastError = 0;
		double derivative = 0;
    
        	double Tp = 180;
        	double turn;
        	double leftPower;
        	double rightPower;

        	float error;
          
          while(true) {
              SensorMode rightLightVal = rightSensor.getRedMode();
              float[] rightValue = new float[rightLightVal.sampleSize()];
              rightLightVal.fetchSample(rightValue, 0);
              
              SensorMode leftLightVal = leftSensor.getRedMode();
              float[] leftValue = new float[leftLightVal.sampleSize()];
              leftLightVal.fetchSample(leftValue, 0);

              error = rightValue[0] - leftValue[0];
              
              integral = integral + error;
               
              derivative = error - lastError;
              
              turn = Kp*error + Ki*integral + Kd*derivative;
              
              leftPower = Tp + turn;
              
              rightPower = Tp - turn;
             
              leftMotor.setSpeed((int) leftPower);
              rightMotor.setSpeed((int) rightPower);
              leftMotor.forward();
              rightMotor.forward();
              lastError = error;
           
          }
     }
}
