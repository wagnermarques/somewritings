#  wagnerdocri@gmail.com
#  Controlando motor brushless com PMW - Pulse Width Modulation
import importlib
importlib.import_module('joystickctl')

import RPi.GPIO as GPIO  
import time              

GPIO.setmode(GPIO.BOARD) #usando numero fisico do pino

GPIO.setup(12, GPIO.OUT)

# Aqui tem um segredinho,
# muitos tutoriais de gpio seta o pwm pra 100Hz
# mas pro esc essa frequencia nao funciona, tem que ser 50
# conforme abaixo
pwm = GPIO.PWM(12, 50)  

# main loop of program
print("\nPress Ctl C to quit \n")  # Print blank line before and after message.
dc=0                # set dc variable to 0 for 0%


time.sleep(5)
pwm.start(0)                      # Start PWM with 0% duty cycle
print("\nSetando com Min = 0")
time.sleep(10)

pwm.ChangeDutyCycle(3)
print("\n Minimo Setado pra 3")
time.sleep(10)


run = True
while run:
    pygame.time.delay(100)
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            run = False
        if event.type == pygame.JOYAXISMOTION:
            print(joysticks[event.joy].get_name() + " JOYAXISMOTION; axis="+ str(event.axis))
        if event.type == pygame.JOYHATMOTION:
            x -= vel
        if event.type == pygame.JOYBALLMOTION:
            print("pygame.JOYBALLMOTION")
        if event.type == pygame.JOYBUTTONDOWN:
            if event.button == 0:
                dc = dc + vel
                pwm.ChangeDutyCycle(dc)
                print("dc="+str(dc)+joysticks[event.joy].get_name() + " JOYBUTTONDOWN btn 0")
            if event.button == 2:
                print("pygame.JOYBUTTONDOWN btn 2")
            if event.button == 3:
                dc = dc - vel
                pwm.ChangeDutyCycle(dc)
                print("dc="+str(dc)+joysticks[event.joy].get_name() + " JOYBUTTONDOWN btn 3")
            if event.button == 1:
                print("pygame.JOYBUTTONDOWN btn 1")
                
        if event.type == pygame.JOYBUTTONUP:
            print("pygame.JOYBUTTONUP")



pwm.stop()                         # stop PWM
GPIO.cleanup()                     # resets GPIO ports used back to input mode
