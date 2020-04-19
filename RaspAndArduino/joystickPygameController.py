import pygame
import sys
import time
import RPi.GPIO as GPIO  
import time              

GPIO.setmode(GPIO.BOARD) #usando numero fisico do pino

GPIO.setup(12, GPIO.OUT)

# Aqui tem um segredinho,
# muitos tutoriais de gpio seta o pwm pra 100Hz
# mas pro esc essa frequencia nao funciona, tem que ser 50
# conforme abaixo
pwm = GPIO.PWM(12, 50)  





x = 50
y = 50
width = 40
height = 60
vel = 5

clock = pygame.time.Clock()
pygame.init()                                                                                                                                                           

screen = pygame.display.set_mode((800, 600))                                                                                                                            

joystick_count = pygame.joystick.get_count()
joysticks = []
pygame.joystick.init()

for i in range(joystick_count):
    joystick = pygame.joystick.Joystick(i)
    joysticks.append(joystick)

for j in joysticks:
    j.init()




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
        if event.type == pygame.JOYBUTTONDOWN:
            if event.button == 0:
                x = x + vel
                dc = dc + vel
                pwm.ChangeDutyCycle(dc)
                print("dc="+str(dc)+joysticks[event.joy].get_name() + " JOYBUTTONDOWN btn 0")
            if event.button == 2:
                x = x - vel
                dc = dc - vel
                pwm.ChangeDutyCycle(dc)
                print("dc="+str(dc)+joysticks[event.joy].get_name() + " JOYBUTTONDOWN btn 3")

    pressed = pygame.key.get_pressed()
    if pressed[pygame.K_UP]:
        x = x + vel
        dc = dc + vel
        pwm.ChangeDutyCycle(dc)
        print("dc="+str(dc)+"arrowUP")
    if pressed[pygame.K_DOWN]:
        x = x - vel
        dc = dc - vel
        pwm.ChangeDutyCycle(dc)
        print("dc="+str(dc)+"arrowDown")
        
    screen.fill((0, 0, 0))                                                                                                                                              
    pygame.draw.rect(screen, (0, 128, 255), pygame.Rect(x, y, 60, 60))                                                                                                  
    pygame.display.flip()                                                                                                                                               
    clock.tick(60)
    
pygame.quit()
pwm.stop()                         # stop PWM
GPIO.cleanup()                     # resets GPIO ports used back to input mode

    
